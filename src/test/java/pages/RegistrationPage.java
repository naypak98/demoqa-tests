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




    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setUserEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void setGender(String value) {
        genterWrapper.$(byText(value)).click();
    }

    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }







    public void checkValue(String attribute, String value) {
        $$("tbody tr").findBy(text("Student Name")).$$("td").get(1).shouldHave(text("Anna Popova"));
    }


}
