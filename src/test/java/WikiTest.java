import data.Language;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.WikipediaComponents;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;



@DisplayName("Wikipedia parametrized test")
public class WikiTest extends TestBase{
WikipediaComponents wikipediaComponents = new WikipediaComponents();

    @EnumSource(Language.class)
    @Tag("BLOCKER")
    @ParameterizedTest(name = "Checking correct language change {0} and its welcome message.")
    void landingPageHasCorrectWelcomeMessage(Language lang) {
        wikipediaComponents
                .openPage()
                .languageSelection(lang)
                .welcomeMessageCheck(lang);
    }

    @ValueSource(strings = {"GitHub", "Java", "Selenide"})
    @ParameterizedTest(name = "Successful search query for {0}")
    @Tag("BLOCKER")
    public void successfulSearchTest(String searchRequest) {
        wikipediaComponents
                .openPage()
                .setValueSearch(searchRequest)
                .checkResultHasContent();
    }

    @CsvFileSource(resources = "/wikiSearchInfo.csv", delimiter = '~')
    @ParameterizedTest (name = "Search query for {0} with correct information being displayed")
    @Tag("BLOCKER")
    void searchResultShouldHaveInformationAboutQuery(String searchRequest, String text) {
        wikipediaComponents
                .openPage()
                .setValueSearch(searchRequest)
                .checkCorrectResult(text);

    }
}

