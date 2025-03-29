package webshop.test.uiclient;

import api.webshop.pages.logout.MainPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class LogoutUser {
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com";

    @Step("Выйти из аккаунта")
    public void logout() {
        open(WEBSITE_URL, MainPage.class)
                .clickLogout()
                .checkLogin("Log in");
    }
}
