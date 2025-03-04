package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Anna");
        $("#userEmail").setValue("anna@gg.ru");
        $("#currentAddress").setValue("Test city, street 1");
        $("#permanentAddress").setValue("Test city, street 2");
        $("#submit").click();

        $("#output #name").shouldHave(text("Anna"));
        $("#output").$("#email").shouldHave(text("anna@gg.ru"));
        $("#output").$("#currentAddress").shouldHave(text("Test city, street 1"));
        $("#output #permanentAddress").shouldHave(text("Test city, street 2"));
    }
}
