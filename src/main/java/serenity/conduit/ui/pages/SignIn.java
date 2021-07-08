package serenity.conduit.ui.pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignIn {
    public static final Target SIGNIN = Target.the("Sign In")
                                         .located(By.xpath("//a[normalize-space()='Sign in']"));

    public static final Target USERNAME = Target.the("Username")
                                          .located(By.xpath("//input[@formcontrolname='email']"));

    public static final Target PASSWORD = Target.the("Password")
                                          .located(By.xpath("//input[@formcontrolname='password']"));

    public static final Target SUBMIT = Target.the("Login Submit")
            .located(By.xpath("//button[@type='submit']"));
}
