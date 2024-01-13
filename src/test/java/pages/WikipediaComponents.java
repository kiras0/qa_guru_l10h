package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

import data.Language;
public class WikipediaComponents {
    private final static SelenideElement
            searchInput = $("#searchInput");
    private final ElementsCollection
            languageSelect = $$(".central-featured-lang a");



    public WikipediaComponents openPage() {
        open("");
        return this;
    }

    public WikipediaComponents setValueSearch(String searchRequest) {
        searchInput.setValue(searchRequest).pressEnter();
        return this;
    }
    public WikipediaComponents languageSelection(Language lang) {
        languageSelect.find(text(lang.name())).click();
        return this;
    }

}
