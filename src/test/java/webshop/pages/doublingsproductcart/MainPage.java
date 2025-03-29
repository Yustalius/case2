package webshop.pages.doublingsproductcart;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
            clickField = $(".qty-input"),
            checkProduct = $(".qty-input"),
            clickUpdateCart = $("[value = 'Update shopping cart']");


    @Step("Нажать на поле изменения количества продуктов")
    public MainPage clickProductField() {
        clickField.click();

        return this;
    }

    @Step("Удвоить количество продуктов")
    public MainPage checkProductCart() {
        checkProduct.setValue("2");

        return this;
    }

    @Step("Нажать на кнопку обновления продуктов")
    public MainPage clickUpdateProduct() {
        clickUpdateCart.click();

        return this;
    }
}
