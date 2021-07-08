package conduit;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import serenity.conduit.ui.pages.ConduitHomePage;

import static serenity.conduit.ui.pages.SignIn.*;

public class ConduitStepDefinitions {

    @Managed
    WebDriver browser;

    Actor john = Actor.named("John");

    @Before
    public void setTheStage(){
      //  OnStage.setTheStage((new OnlineCast()));
    }

    @Given("that John is on home page")
    public void that_john_is_on_home_page() {
          System.out.println("starting Given");
        john.can(BrowseTheWeb.with(browser));
        john.attemptsTo(Open.browserOn().the(ConduitHomePage.class),
                Click.on(SIGNIN),
                Enter.theValue("yadavsachin0402@gmail.com").into(USERNAME),
                Enter.theValue("Mera$4conduit").into(PASSWORD),
                Click.on(SUBMIT)
        );
        System.out.println("ending given");
    }
    @When("John creates a new article with Rose-ringed parakeet , Information about Rose-ringed parakeet, The Indian ring-necked parakeet is not a shy bird, parakeet")
    public void john_creates_a_new_article_with_rose_ringed_parakeet_information_about_rose_ringed_parakeet_the_indian_ring_necked_parakeet_is_not_a_shy_bird_parakeet() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("article should be present at home page global feed tab")
    public void article_should_be_present_at_home_page_global_feed_tab() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
