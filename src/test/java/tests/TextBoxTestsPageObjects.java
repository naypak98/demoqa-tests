package tests;

import org.junit.jupiter.api.Test;
import pages.TextBox;


public class TextBoxTestsPageObjects extends TestBase {

TextBox textBox = new TextBox();
    @Test
    void fillFormTest() {
        textBox.openPage()
                .setFullName("Anna")
                .setUserEmail("anna@gg.ru")
                .setCurrentAddress("Test city, street 1")
                .setPermanentAddress("Test city, street 2")
                .submit()
                .checkResult("Name:", "Anna")
                .checkResult("Email:", "anna@gg.ru")
                .checkResult("Current Address :", "Test city, street 1")
                .checkResult("Permananet Address :", "Test city, street 2");



    }
}
