package demowebshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductCatalogPage {

    private final SelenideElement
            productsPerPageDropdown = $("#products-pagesize"),
            productsFour = $("[value='https://demowebshop.tricentis.com/apparel-shoes?pagesize=4']"),
            productsEight = $("[value='https://demowebshop.tricentis.com/apparel-shoes?pagesize=8']"),
            productsTwelve = $("[value='https://demowebshop.tricentis.com/apparel-shoes?pagesize=12']");

    private final ElementsCollection
            checkProducts = $$(".item-box");


    @Step("Нажать на выпадающий список")
    public ProductCatalogPage clickOnTheDropdownList() {
    productsPerPageDropdown.click();

        return this;

    }

    @Step("Выбрать 4")
    public ProductCatalogPage clickOnFour() {
        productsFour.click();

        return this;

    }

    @Step("Проверить что на странице 4 продукта")
    public ProductCatalogPage checkFourProductsPage() {
        checkProducts.shouldHave(size(4));

        return this;
    }

    @Step("Выбрать 8")
    public ProductCatalogPage clickOnEight() {
        productsEight.click();

        return this;
    }
    @Step("Проверить что на странице 8 продуктов")
    public ProductCatalogPage checkEightProductsPage() {
        checkProducts.shouldHave(size(8));

        return this;
    }

    @Step("Выбрать 12")
    public ProductCatalogPage clickOnTwelve() {
        productsTwelve.click();

        return this;
    }
    @Step("Проверить что на странице 12 продуктов")
    public ProductCatalogPage checkTwelveProductsPage() {
        checkProducts.shouldHave(size(12));

        return this;
    }


    @Step("Нажать на товар для перехода в его карточку")
    public ProductPage clickProductName(String productName) {
        $(byText(productName)).click();

        return new ProductPage();
    }
}
