package homerwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

class CheckTitle {

    WebDriver driver;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @DisplayName("Website title tests")
    @Tag("Regression")

    void checkTitle(String site, String title) {

        driver.get(site);
        String actualTitle = driver.getTitle();
        String expectedTitle = title;
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

}
