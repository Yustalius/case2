package webshop.pages.deleteproductcart;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
            selectProduct = $("[name = 'removefromcart']"),
            clickUpdateCart = $("[value = 'Update shopping cart']"),
            checkCart = $(".order-summary-content");

    @Step("Выбрать продукт в корзине")
    public MainPage selectToProduct() {
        selectProduct.click();

        return this;
    }

    @Step("Нажать на обновление корзины")
    public MainPage updateToCart() {
        clickUpdateCart.click();

        return this;
    }

    @Step("Проверить надпись {}")
    public MainPage checkToUpdateCart(String message) {
        checkCart.shouldHave(text(message));

        return this;
    }
}
