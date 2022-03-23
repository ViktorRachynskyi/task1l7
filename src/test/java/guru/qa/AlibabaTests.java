package guru.qa;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Alibaba tests/ annotation isn't displayed")
class AlibabaTests extends BaseTest {

    @Tag("electronic")
    @DisplayName("Open consumer electronics pages")
    @ParameterizedTest(name = "Open \"{0}\" page")
    @ValueSource(strings = {"Camera, Photo & Accessories", "Computer Hardware & Software"})
    public void openTabsByCategories(String pageName) {
        $x("//span[contains(text(),'" + pageName + "')]").click();
        $("h1.path").shouldHave(text(pageName));
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }

    @Tag("authorization")
    @DisplayName("Verification frame is appeared")
    @ParameterizedTest(name = "Check secure frame use email \"{0}\"")
    @MethodSource("credentials")
    void checkSecureVerificationTest(String email, String pass) {
        $("div.sc-hd-ms-login").click();
        $("#fm-login-id").setValue(email);
        $("#fm-login-password").setValue(pass);
        $("iframe#baxia-dialog-content").shouldBe(visible);
    }

    public static Stream<Arguments> credentials() {

        return Stream.of(
                Arguments.of("test-mail1@gmail.com", "test_pass1"),
                Arguments.of("test-mail2@gmail.com", "test_pass2"),
                Arguments.of("test-mail3@gmail.com", "test_pass3")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "January, 15",
            "February, 0x05",
            "July, 29"
    })
    void csvSourceTest(String month, int day) {
        System.out.println("Month: " + month + "\n" + "Day: " + day);

    }

    @Test
    @Disabled
    void disabledTest() {
        System.out.println("This test should be disabled!");
    }
}
