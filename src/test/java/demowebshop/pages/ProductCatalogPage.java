package demowebshop.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ProductCatalogPage {

    @Step("Нажать на товар для перехода в его карточку")
    public ProductPage clickProductName(String productName) {
        $(byText(productName)).click();

        return new ProductPage();
    }
}
