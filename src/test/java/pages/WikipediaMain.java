package pages;

import com.codeborne.selenide.SelenideElement;
import data.Language;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikipediaMain {
    private final static SelenideElement
            welcomeMessage = $("#mw-content-text");

    public WikipediaMain welcomeMessageCheck(Language lang) {
        welcomeMessage.shouldHave(text(lang.description));
        return this;
    }
}
