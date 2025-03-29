package webshop.test.uiclient;

import api.webshop.pages.doublingsproductcart.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class DoublingsProductCart {
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com/cart";

    @Step("Удваевание продуктов в корзине")
    public void doublingsProduct() {
        open(WEBSITE_URL, MainPage.class)
                .clickProductField()
                .checkProductCart()
                .clickUpdateProduct();
    }
}
