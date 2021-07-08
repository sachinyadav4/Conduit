package serenity.conduit.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://candidatex:qa-is-cool@qa-task.backbasecloud.com/")
public class ConduitHomePage extends PageObject {

    @Managed
    WebDriver driver;

    public static final Target NEWARTICLE = Target.the("Sign In")
            .located(By.className("ion-compose"));
    /*
    Test Data for creating a new article
     */
    public static final String TITLEINPUT = "Rose-ringed parakeet";
    public static final String SUMMARYINPUT = "Information about Rose-ringed parakeet";
    public static final String TEXTINPUT = "The Indian ring-necked parakeet is not a shy bird," +
                                       "and does best with an owner who appreciates an outgoing" +
                                       " companion that is not afraid to demand what it wants! " +
                                       "Indian ring-necks can also be quite talkative.";
    public static final String TAGSINPUT = "parakeet";

    public static final Target TITLE = Target.the("Article Title")
            .located(By.cssSelector("input[formcontrolname='title']"));

    public static final Target SUMMARY = Target.the("Article Summary")
            .located(By.cssSelector("input[formcontrolname='description']"));

    public static final Target TEXTBODY = Target.the("Article Text Body")
            .located(By.cssSelector("[formcontrolname='body']"));

    public static final Target ENTERTAGS = Target.the("Enter Tags")
            .located(By.cssSelector("input[placeholder='Enter tags']"));

    public static final Target PUBLISHARTICLE = Target.the("Publish Article")
            .located(By.cssSelector("button[type='button']"));

    public static final Target PUBLISHEDTITLE = Target.the("Published Article paragraph")
            .located(By.xpath("//p"));

    public static final Target HOME = Target.the("Home Link")
            .located(By.xpath("//a[contains(.,'Home')]"));

    public static final Target GLOBALFEED = Target.the("Global Feed Tab")
            .located(By.xpath("//a[contains(.,'Global Feed')]"));

    public static final Target ALLTITLES = Target.the("All Titles")
            .located(By.xpath("//h1"));

    public static final Target EDITTITLE = Target.the("Edit Titles")
            .located(By.xpath("//h1[normalize-space()='"+ TITLEINPUT +"']"));

    public static final Target EDITARTICLEBUTTON1 = Target.the("Edit Article Button 1")
            .located(By.cssSelector("div[class='container'] i[class='ion-edit']"));

    public static final Target DELETEARTICLEBUTTON1 = Target.the("Edit Article Button 1")
            .located(By.cssSelector("div[class='container'] i[class='ion-trash-a']"));

    /*
    Test Data for creating a new article
    */
    public static final String H = "Rose-ringed parakeet";


}
