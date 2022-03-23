package guru.qa;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@DisplayName("tet")
public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll method ----------------");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach method ----------------");
        open("https://www.alibaba.com/");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach method ----------------");
        closeWebDriver();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll method ----------------");
    }
}
