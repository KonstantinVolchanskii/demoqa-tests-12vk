package tests;

import com.codeborne.selenide.Configuration;
import guru.qa.Pages.RegistrationFormPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TestBoxTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userGender = faker.demographic().sex(),
            currentAddress = faker.address().fullAddress(),
            userNumber = faker.numerify("##########"),
            day = "13",
            month = "February",
            year = "1987",
            subjects = "Maths",
            hobbies = "Sports",
            picture = "vodorosli_rastenie_makro_krupnym_planom_106345_1920x1080.jpg",
            state = "Haryana",
            city = "Karnal";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void RegistrationTests() {
        RegistrationFormPage registrationFormPage = this.registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubjects(subjects)
                .setUserHobbies(hobbies)
                .setupLoadPicture(picture)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .setsubmitClick()
                // Asserts
                .checkCompletedForm("Student Name", firstName + " " + lastName)
                .checkCompletedForm("Student Email", userEmail)
                .checkCompletedForm("Gender", userGender)
                .checkCompletedForm("Number", userNumber)
                .checkCompletedForm("Birthday", day + "." + month + "." + year)
                .checkCompletedForm("Subjects", subjects)
                .checkCompletedForm("Hobbies", hobbies)
                .checkCompletedForm("Picture", picture)
                .checkCompletedForm("Current Address", currentAddress)
                .checkCompletedForm("State and City", state + " " + city);
    }
}