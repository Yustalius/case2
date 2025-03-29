package webshop.pages.searchtowebshop;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductCatalogPage {
    private final SelenideElement
            checkProduct = $("h2.product-title a");

    @Step("Проверить что товар отображается")
    public ProductCatalogPage checkProductDisplay(String productName) {
        checkProduct.shouldHave(text(productName));

        return this;
    }
}
