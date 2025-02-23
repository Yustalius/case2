package my_progect;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Caban {
    @Test
    void caban() {
        String productName = "50's Rockabilly Polka Dot Top JR Plus Size";
        Configuration.holdBrowserOpen = true;
        open("https://demowebshop.tricentis.com/");
        $(".ico-login").click();
        $("#Email").setValue("1111caban@mail.ru");
        $("#Password").setValue("aaa123");
        $("[value='Log in']").click();
        $(".header-links ul .account").shouldHave(text("1111caban@mail.ru"));
        $(byText("Apparel & Shoes")).click();
        $(byText(productName)).click();
        $(".current-item").shouldHave(text(productName.toUpperCase()));
        $("#add-to-cart-button-5").click();
        $("#topcartlink .cart-label").click();
        refresh();
        $("span.cart-qty").shouldHave(text("(1)"));




    }
}
