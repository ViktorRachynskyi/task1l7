package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Open Alibaba pages")
public class PathTests extends BaseTest {

    @DisplayName("Open consumer electronics pages")
    @ParameterizedTest(name = "Opening \"{0}\" page")
    @ValueSource(strings = {"Speakers & Accessories", "Camera, Photo & Accessories", "Computer Hardware & Software"})
    void openTabsByCategories(String pageName) {
        $x("//span[contains(text(),'" + pageName + "')]").click();
        $("h1.path").shouldHave(text(pageName));
    }

    @Test
    @DisplayName("Day calculate")
    void secondTest() {
    }
}
