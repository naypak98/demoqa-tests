package tests;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;


public class PracticeFormTestsPageObjectsWithTestData extends TestBase {


    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormFulLTest() {

        Faker faker = new Faker(new Locale("en","IN"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String gender = RandomUtils.getRandomGender();
        String phoneNumber = RandomUtils.getSimpleRandomPhone();
        String day = String.valueOf(RandomUtils.getRandomInt(1, 28));
        String year = String.valueOf(RandomUtils.getRandomInt(1950, 2024));
        String month = RandomUtils.getRandomMonth();
        String subject = RandomUtils.getRandomSubject();
        String hobby = RandomUtils.getRandomHobby();
        String filePath = "src/testData/kotik.jpg";
        String address = faker.address().fullAddress();
        String state = RandomUtils.getRandomState();
        String city = RandomUtils.getRandomCity(state);
        String headingText = "Thanks for submitting the form";





        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDateOfBirth(day, month, year)
                .selectSubject(subject)
                .selectHobby(hobby)
                .uploadPicture(filePath)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .submit()
                .checkModalHeading(headingText)
                .checkResult("Student Name",String.format("%s %s", firstName, lastName))
                .checkResult("Student Email",email)
                .checkResult("Gender",gender)
                .checkResult("Mobile",phoneNumber)
                .checkResult("Date of Birth",String.format("%s %s,%s", day, month, year))
                .checkResult("Subjects",subject)
                .checkResult("Hobbies",hobby)
                .checkResult("Address",address)
                .checkResult("State and City",String.format("%s %s", state, city));


    }

    @Test
    void fillPracticeFormPositiveTest() {

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String gender = RandomUtils.getRandomGender();
        String phoneNumber = RandomUtils.getSimpleRandomPhone();
        String headingText = "Thanks for submitting the form";


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .submit()
                .checkModalHeading(headingText)
                .checkResult("Student Name", String.format("%s %s", firstName, lastName))
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);

    }

    @Test
    void fillPracticeFormNegativeTest() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String gender = RandomUtils.getRandomGender();
        String wrongNumber = String.valueOf(RandomUtils.getRandomInt(11,9999));


        registrationPage.openPage()
                .setFirstName(firstName)
                .setGender(gender)
                .setUserNumber(wrongNumber)
                .submit()
                .modalDialogDidntAppear();

    }





}
