package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalDialogComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private  SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genterWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput =  $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbyInput = $("#hobbiesWrapper"),
            fileInput = $("#uploadPicture"),
            addressInput =  $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit"),
            modalDialog =  $(".modal-dialog");


    CalendarComponent calendarComponent = new CalendarComponent();
    ModalDialogComponent modalDialogComponent = new ModalDialogComponent();




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

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;

    }

    public RegistrationPage selectSubject(String text) {
       subjectsInput.click();
       subjectsInput.setValue(text).pressEnter();

        return this;
    }

    public RegistrationPage selectHobby(String text) {
       hobbyInput.$(byText(text)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String link) {
        File file = new File(link);
        fileInput.uploadFile(file);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public RegistrationPage selectState(String state) {
        stateInput.click();
        stateInput.find(byText(state)).click();

        return this;
    }

    public RegistrationPage selectCity(String city) {
        cityInput.click();
        cityInput.find(byText(city)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();

        return this;
    }


    public RegistrationPage checkModalHeading(String text) {
        modalDialogComponent.checkHeading(text);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        modalDialogComponent.checkResult(key, value);

        return this;
    }

    public RegistrationPage modalDialogDidntAppear() {
        modalDialog.shouldNot(appear);
        return this;
    }


}
