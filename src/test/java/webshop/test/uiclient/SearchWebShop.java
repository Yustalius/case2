package webshop.test.uiclient;

import api.webshop.pages.searchtowebshop.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class SearchWebShop {
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com";

    @Step("Поиск по магазину")
     public void searchToWebShop() {
        open(WEBSITE_URL, MainPage.class)
                .clickOnTheSearch()
                .enterProductName("Blue Jeans")
                .clickButtonSearch()
                .checkProductDisplay("Blue Jeans");
    }
}
