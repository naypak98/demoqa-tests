package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTestsPageObjects extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeForm() {

        registrationPage.openPage()
                .setFirstName("Anna")
                .setLastName("Popova")
                .setUserEmail("anna@popova.com")
                .setGender("Female")
                .setUserNumber("9123454562")
                .setDateOfBirth("21", "January", "1995")
                .selectSubject("Math")
                .selectHobby("Reading")
                .uploadPicture("src/testData/kotik.jpg")
                .setAddress("Test city, street 1")
                .selectState("Uttar Pradesh")
                .selectCity("Agra")
                .submit()
                .checkModalHeading("Thanks for submitting the form")
                .checkResult("Student Name","Anna Popova")
                .checkResult("Student Email","anna@popova.com")
                .checkResult("Gender","Female")
                .checkResult("Mobile","9123454562")
                .checkResult("Date of Birth","21 January,1995")
                .checkResult("Subjects","Maths")
                .checkResult("Hobbies","Reading")
                .checkResult("Address","Test city, street 1")
                .checkResult("State and City","Uttar Pradesh Agra");


    }

}
