package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;

    }

    @Test
    void fillPracticeForm() {
        open("/automation-practice-form");
        $("#firstName").setValue("Anna");
        $("#lastName").setValue("Popova");
        $("#userEmail").setValue("anna@popova.com");
        $("label[for='gender-radio-2']").click();
        $("#userNumber").setValue("9123454562");
        //date
        $("#dateOfBirthInput").click(); // Открываем календарь
        $(".react-datepicker__month-select").selectOption("January"); // Выбираем месяц
        $(".react-datepicker__year-select").selectOption("1995"); // Выбираем год
        $(".react-datepicker__day--021").click(); // Кликаем по числу 21
        //
        //Subjects
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("M");
        $(".subjects-auto-complete__menu-list").$(byText("Maths")).click(); //setTimeout(function() {debugger;}, 5000)
        //
        $("label[for='hobbies-checkbox-2']").click();
        File file = new File("src/testData/kotik.jpg");
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue("Test city, street 1");
        //state
        $("#state").click();
        $(".css-26l3qy-menu").find(byText("Uttar Pradesh")).click();
        //city
        $("#city").click();
        $(".css-26l3qy-menu").find(byText("Agra")).click();

        $("#submit").click();



















    }

}
