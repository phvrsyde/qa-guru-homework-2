import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TesyBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1980x1080";
         }
}
