import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class CheckFormTest extends TestBase {

    @Test
    void firstTest() {
        open ("/automation-practice-form");

        // отключить рекламу
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // заполнить форму студента
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanivan@pochta.po");

        // пол
        $("#genterWrapper").$(byText("Male")).click();

        // номер телефона
        $("#userNumber").setValue("9874561234");

        // ДР
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("November")).click();
        $(".react-datepicker__year-select").click();
        $(byText("1991")).click();
        $(".react-datepicker__day--001").click();

        // выбор предмета
        $("#subjectsInput").setValue("Arts").click();
        $(".subjects-auto-complete__menu").click();

        // выбор хобби
        $("#hobbiesWrapper").$(byText("Music")).click();

        // загрузка изображения
        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

        // адрес
        $("#currentAddress").setValue("Some street 1");

        // штат и город
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //отправить
        $("#submit").click();

        //проверить
        $(".table-responsive").shouldHave(text("Ivan"),
                text("Ivanov"),
                text("ivanivan@pochta.po"),
                text("Male"),
                text("9874561234"),
                text("01 November,1991"),
                text("Arts"),
                text("Music"),
                text("1.png"),
                text("Some street 1"),
                text("NCR"),
                text("Delhi"));

           }
}
