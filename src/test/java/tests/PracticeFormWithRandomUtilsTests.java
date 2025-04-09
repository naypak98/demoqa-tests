package tests;

import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.*;

public class PracticeFormWithRandomUtilsTests extends TestBase{


    @Test
    void fillPracticeForm() {
        String firstName = getRandomString(10);
        String lastName = getRandomString(10);
        String userEmail = getRandomEmail();
//        String streetAddress = "";

        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
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
        $("label[for='hobbies-checkbox-2']").click(); //reading
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

        //check result
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $$("tbody tr").findBy(text("Student Name")).$$("td").get(1).shouldHave(text("Anna Popova"));
        $$("tbody tr").findBy(text("Student Email")).$$("td").get(1).shouldHave(text("anna@popova.com"));
        $$("tbody tr").findBy(text("Gender")).$$("td").get(1).shouldHave(text("Female"));
        $$("tbody tr").findBy(text("Mobile")).$$("td").get(1).shouldHave(text("9123454562"));
        $$("tbody tr").findBy(text("Date of Birth")).$$("td").get(1).shouldHave(text("21 January,1995"));
        $$("tbody tr").findBy(text("Subjects")).$$("td").get(1).shouldHave(text("Maths"));
        $$("tbody tr").findBy(text("Hobbies")).$$("td").get(1).shouldHave(text("Reading"));
        $$("tbody tr").findBy(text("Picture")).$$("td").get(1).shouldHave(text("kotik.jpg"));
        $$("tbody tr").findBy(text("Address")).$$("td").get(1).shouldHave(text("Test city, street 1"));
        $$("tbody tr").findBy(text("State and City")).$$("td").get(1).shouldHave(text("Uttar Pradesh Agra"));




    }

}
