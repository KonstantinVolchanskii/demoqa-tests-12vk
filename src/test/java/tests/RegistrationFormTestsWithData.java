package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class RegistrationFormTestsWithData {

    //Блок переметров
   //RegistrationFormTestsWithData LocalDate birth = LocalDate.of(1987, 2, 13);    //дата в стандартном для Java формате
    String firstName = "Fedor",
             lastName = "Bobrov",
             email = "Bobrov@mail.ru";
    String expectedFullName= format("%s %s", firstName, lastName);
    String gender = "Male";
    String phoneNumber = "88001234567";
    String subject = "English";
    String hobby = "Music";
    String imgPath = "vodorosli_rastenie_makro_krupnym_planom_106345_1920x1080.jpg";
    String address = "Shantipath, Chanakyapuri, New Delhi, 110021";
    String state = "NCR";
    String city = "Delhi";
    String month = birth.getMonth().toString().charAt(0)                 //получаем из даты название месяца
            + birth.getMonth().toString().substring(1).toLowerCase();
    SelenideElement stateCity = $("#stateCity-wrapper");
    ArrayList<SelenideElement> actions = new ArrayList<>();
        actions.add(stateCity.$(byText("Select State")));
        actions.add(stateCity.$(byText(state)));
        actions.add(stateCity.$(byText("Select City")));
        actions.add(stateCity.$(byText(city)));

    @BeforeAll
    static void prepare() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void execute() {


        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixeban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(String.valueOf(birth.getYear()));
        $("[aria-label$='" + month + " " + birth.getDayOfMonth() + "th, " + birth.getYear() + "']").click();
        //$(byXpath("//div[@class='react-datepicker__day react-datepicker__day--0" + birth.getDayOfMonth() + "']")).click();        //альтернатива через Xpath
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(imgPath);
        $("#currentAddress").setValue(address);
        for (SelenideElement selenideElement : actions) {
            selenideElement.click();                                //прокликиваем всю коллекцию
        }

        //$("#state").click();
        //$("#stateCity-wrapper").$(byText("NCR")).click();
        //$("#city").click();
        //$("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        //Блок проверок
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(expectedFullName), text(email), text(gender));
        //$(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Fedor Bobrov"));
        $("#closeLargeModal").click();
    }
}
