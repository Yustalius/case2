package webshop.pages.logout;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement
            logoutClick = $(".ico-logout"),
            loginCheck = $(".ico-login");

    @Step("Нажать на кнопку выхода")
    public MainPage clickLogout() {
        logoutClick.click();

        return this;
    }

    @Step("Проверить кнопку авторизации")
    public MainPage checkLogin(String buttonLogin) {
        loginCheck.shouldHave(text(buttonLogin));

        return this;
    }
}
