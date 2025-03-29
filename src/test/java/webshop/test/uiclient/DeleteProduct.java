package webshop.test.uiclient;

import api.webshop.pages.deleteproductcart.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class DeleteProduct {
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com/cart";

    @Step("Удаление продукта из корзины")
    public void deleteProductCart() {
        open(WEBSITE_URL, MainPage.class)
                .selectToProduct()
                .updateToCart()
                .checkToUpdateCart("Your Shopping Cart is empty!");
    }
}
