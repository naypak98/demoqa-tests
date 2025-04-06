package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBox {
    private SelenideElement fullNameInput =$("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            output =  $("#output");

    public TextBox openPage() {
        open("/text-box");

        return this;
    }

    public TextBox setFullName(String name) {
        fullNameInput.setValue(name);

        return this;
    }

    public TextBox setUserEmail(String email) {
        userEmailInput.setValue(email);

        return this;
    }

    public TextBox setCurrentAddress(String curAddress) {
        currentAddressInput.setValue(curAddress);

        return this;
    }

    public TextBox setPermanentAddress(String perAddress) {
        permanentAddressInput.setValue(perAddress);

        return this;
    }

    public TextBox submit() {
        submitButton.click();

        return this;
    }

    public TextBox checkResult(String key, String value) {
        output.$(byText(key)).shouldHave(text(value));

        return this;
    }




}
