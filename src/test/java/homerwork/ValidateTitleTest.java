package homerwork;

import Utils.Hooks;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateTitleTest extends Hooks {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    @DisplayName("Website title tests")
    @Tag("Regression")
    void checkTitle(String site, String title) {

        getDriver().get(site);
        String actualTitle = getDriver().getTitle();
        String expectedTitle = title;
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }

}
