package webshop.pages.addingproducttoyourwishlist;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement
            clickWishlist = $("#add-to-wishlist-button-5"),
            checkMassege = $(".content");

    @Step("Нажать на добавление в список желаний")
    public MainPage clickToWishlist() {
        clickWishlist.click();

        return this;
    }

    @Step("Проверить надпись подтверждения")
    public MainPage checkConfirmationMessage(String message) {
        checkMassege.shouldHave(text(message));

        return this;
    }
}
