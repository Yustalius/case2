package webshop.pages.searchtowebshop;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private final SelenideElement
            clickSearch = $("#small-searchterms"),
            productNameInput = $("#small-searchterms"),
            clickButton = $("[value ='Search']");

    @Step("Нажать на поле поиска")
    public MainPage clickOnTheSearch() {
        clickSearch.click();

        return this;
    }

    @Step("Ввести название продукта {}")
    public MainPage enterProductName(String productName) {
        productNameInput.setValue(productName);

        return this;
    }

    @Step("Нажать на кнопку поиска")
    public ProductCatalogPage clickButtonSearch() {
        clickButton.click();

        return new ProductCatalogPage();
    }
}
