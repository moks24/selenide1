import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CartDeliveryTest {

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    }

    @Test
    public void shouldFillInTheForm(){
        String planningDate = generateDate(4);
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").val("Оренбург");
        $("[type='tel']").sendKeys(Keys.CONTROL + "a");
        $("[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").val(planningDate);
        $("[data-test-id='name'] input").val("Иванов Андрей");
        $("[name='phone']").val("+79225558899");
        $("[class='checkbox__box']").click();
        $("[class='button__text']").click();
        $("[class='notification__content']").shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно забронирована на " + planningDate));
    }

}
