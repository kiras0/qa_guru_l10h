package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WikipediaResults {
    private final static SelenideElement
            content = $("#bodyContent");

    private final ElementsCollection
            sideContentLocator = $(".vector-toc").$$(".vector-toc-contents");

    public WikipediaResults checkResultHasContent() {
        sideContentLocator.shouldBe(sizeGreaterThan(0));
        return this;
    }

    public WikipediaResults checkCorrectResult(String text) {
        content.shouldHave(text(text));
        return this;
    }
}
