package webshop.test.uiclient;

import api.webshop.pages.addingproducttoyourwishlist.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class AddingProduct {
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com/50s-rockabilly-polka-dot-top-jr-plus-size";


    @Step("Добавление продукта в список желаний")
    public void addingProductToYourWishlist() {
        open(WEBSITE_URL, MainPage.class)
                .clickToWishlist()
                .checkConfirmationMessage("The product has been added to your ");
    }
}
