package serenity.conduit.test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import serenity.conduit.ui.pages.ConduitHomePage;
import serenity.conduit.ui.pages.SignIn;
import serenity.conduit.questions.Article;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WhenCRUDConduit {

    Actor john = Actor.named("John the user");

    @Managed
    WebDriver browser;

    @Before
    public void setTheStage(){
        john.can(BrowseTheWeb.with(browser));
        john.attemptsTo(Open.browserOn().the(ConduitHomePage.class),
                Click.on(SignIn.SIGNIN),
                Enter.theValue("yadavsachin0402@gmail.com").into(SignIn.USERNAME),
                Enter.theValue("Mera$4conduit").into(SignIn.PASSWORD),
                Click.on(SignIn.SUBMIT)
        );
    }

    @Test
    public void test1_create_a_new_article() throws InterruptedException {
        john.attemptsTo(Click.on(ConduitHomePage.NEWARTICLE),
                        Enter.theValue(ConduitHomePage.TITLEINPUT).into(ConduitHomePage.TITLE),
                        Enter.theValue(ConduitHomePage.SUMMARYINPUT).into(ConduitHomePage.SUMMARY),
                        Enter.theValue(ConduitHomePage.TEXTINPUT).into(ConduitHomePage.TEXTBODY),
                        Enter.theValue(ConduitHomePage.TAGSINPUT).into(ConduitHomePage.ENTERTAGS),
                        Click.on(ConduitHomePage.PUBLISHARTICLE),
                        WaitUntil.the(ConduitHomePage.PUBLISHEDTITLE, isVisible()).forNoMoreThan(10).seconds());

        john.should(seeThat(Article.getTitle(),containsString("The Indian ring-necked parakeet")));
    }

    @Test
    public void test2_verify_new_article_under_global_feed() throws InterruptedException {
        john.attemptsTo(WaitUntil.the(ConduitHomePage.HOME, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(ConduitHomePage.HOME),
                        WaitUntil.the(ConduitHomePage.GLOBALFEED, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(ConduitHomePage.GLOBALFEED),
                        WaitUntil.the(ConduitHomePage.PUBLISHEDTITLE, isVisible()).forNoMoreThan(10).seconds());


        john.should(seeThat(Article.getAllTitle(),hasItem("Rose-ringed parakeet")));
    }

    @Test
    public void test3_verify_new_article_updated_successfully() throws InterruptedException {

        john.attemptsTo(WaitUntil.the(ConduitHomePage.HOME, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(ConduitHomePage.HOME),
                        WaitUntil.the(ConduitHomePage.GLOBALFEED, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(ConduitHomePage.GLOBALFEED),
                        WaitUntil.the(ConduitHomePage.ALLTITLES, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(ConduitHomePage.EDITTITLE),
                        WaitUntil.the(ConduitHomePage.EDITARTICLEBUTTON1, isVisible()).forNoMoreThan(10).seconds(),
                        Click.on(ConduitHomePage.EDITARTICLEBUTTON1),
                        WaitUntil.the(ConduitHomePage.TEXTBODY, isVisible()).forNoMoreThan(10).seconds(),
                        Enter.theValue("xyz12345").into(ConduitHomePage.TEXTBODY),
                        Click.on(ConduitHomePage.PUBLISHARTICLE),
                        WaitUntil.the(ConduitHomePage.PUBLISHEDTITLE, isVisible()).forNoMoreThan(10).seconds());

        john.should(seeThat(Article.getBodyInput(),containsString("xyz12345")));
    }

    @Test
    public void test4_verify_deletion_of_new_article() throws InterruptedException {

        john.attemptsTo(Click.on(ConduitHomePage.HOME),
                Click.on(ConduitHomePage.GLOBALFEED),
                WaitUntil.the(ConduitHomePage.PUBLISHEDTITLE, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConduitHomePage.EDITTITLE),
                WaitUntil.the(ConduitHomePage.DELETEARTICLEBUTTON1, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConduitHomePage.DELETEARTICLEBUTTON1),
                WaitUntil.the(ConduitHomePage.GLOBALFEED, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ConduitHomePage.GLOBALFEED),
                WaitUntil.the(ConduitHomePage.ALLTITLES, isVisible()).forNoMoreThan(10).seconds()
        );

        john.should(GivenWhenThen.seeThat(WebElementQuestion.the(ConduitHomePage.TITLEINPUT),
                WebElementStateMatchers.isNotCurrentlyVisible()));

    }
}
