package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import data.Language;
public class WikipediaComponents {
    private final static SelenideElement
            searchInput = $("#searchInput"),
            welcomeMessage = $("#mw-content-text"),
            content = $("#bodyContent");


    public WikipediaComponents openPage() {
        open("");
        return this;
    }

    public WikipediaComponents setValueSearch(String searchRequest) {
        searchInput.setValue(searchRequest).pressEnter();
        return this;
    }
    public WikipediaComponents checkResultHasContent() {
        $(".vector-toc").$$(".vector-toc-contents").shouldBe(sizeGreaterThan(0));
        return this;
    }

    public WikipediaComponents languageSelection(Language lang) {
        $$(".central-featured-lang a").find(text(lang.name())).click();
        return this;
    }
    public WikipediaComponents welcomeMessageCheck(Language lang) {
        welcomeMessage.shouldHave(text(lang.description));
        return this;
    }

    public WikipediaComponents checkCorrectResult(String text) {
        content.shouldHave(text(text));
        return this;
    }
}
