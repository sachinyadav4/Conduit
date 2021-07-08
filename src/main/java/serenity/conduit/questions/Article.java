package serenity.conduit.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import serenity.conduit.ui.pages.ConduitHomePage;

import java.util.List;

public class Article {
    public static Question<String> getTitle() {
        return TheTarget.textOf(ConduitHomePage.PUBLISHEDTITLE);
    }

    public static Question<List<String>> getAllTitle() {
        return TheTarget.textValuesOf(ConduitHomePage.ALLTITLES);
    }

    public static Question<String> getBodyInput() {
        return TheTarget.textOf((ConduitHomePage.PUBLISHEDTITLE));
    }
}
