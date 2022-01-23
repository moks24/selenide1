import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class CartDeliveryTest {

    @Test
    public void shouldFillInTheForm(){
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").val("Оренбург");
        $("[type='tel']").sendKeys(Keys.CONTROL + "a");
        $("[type='tel']").sendKeys(Keys.BACK_SPACE);
        $("[type='tel']").val("31.01.2022");
        $("[data-test-id='name'] input").val("Иванов Андрей");
        $("[name='phone']").val("+79225558899");
        $("[class='checkbox__box']").click();
        $("[class='button__text']").click();
        $("[data-test-id='notification']").shouldBe(visible, Duration.ofSeconds(15));
    }

}
