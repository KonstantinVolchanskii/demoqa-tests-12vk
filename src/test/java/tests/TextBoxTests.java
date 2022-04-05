package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selectors.byXpath; //если понадобится скролл
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void prepare() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void execute() {
        //Блок переметров
        LocalDate birth = LocalDate.of(1987, 2, 13);    //дата в стандартном для Java формате
        String firstName = "Fedor";
        String lastName = "Bobrov";
        String email = "Bobrov@mail.ru";
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

