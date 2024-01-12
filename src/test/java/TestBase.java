import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://wikipedia.org";
    }
}


