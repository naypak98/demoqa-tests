package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber");




    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;

    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;

    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        genterWrapper.$(byText(value)).click();

        return this;

    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;

    }

    public RegistrationPage setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--021").click();

        return this;

    }











}
