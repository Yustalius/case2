package webshop.pages.filterproductsbyprice;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement
            clickFilter = $("#products-orderby"),
            selectFilter = $("#products-orderby");
    private final ElementsCollection
            updateProduct = $$(".product-item");

    @Step("Нажать на список выбора фильтров")
    public MainPage clickOnTheFilter() {
        clickFilter.click();

        return this;
    }

    @Step("Выбрать фильтр")
    public MainPage selectToFilter() {
        selectFilter.selectOption("Price: Low to High");

        return this;
    }

    @Step("Ждем обновления списка продуктов")
    public MainPage productListUpdate() {
        updateProduct.shouldHave(sizeGreaterThan(0));

        return this;
    }
}
