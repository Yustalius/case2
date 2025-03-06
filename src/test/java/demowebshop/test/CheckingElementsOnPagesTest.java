package demowebshop.test;

import com.codeborne.selenide.Selenide;
import demowebshop.pages.MainPage;
import demowebshop.pages.ProductCatalogPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckingElementsOnPagesTest extends TestBase {
    private static final String PRODUCT_CALALOGE_URL = "https://demowebshop.tricentis.com/apparel-shoes";

    @Test
    @DisplayName("Проверка отображения 4, 8 и 12 продуктов на странице")
    void verifyProductsPerPage() {
        Selenide.open(PRODUCT_CALALOGE_URL, ProductCatalogPage.class)
                .selectProductsPerPage(4)
                .verifyProductsCount(4)
                .selectProductsPerPage(8)
                .verifyProductsCount(8)
                .selectProductsPerPage(12)
                .verifyProductsCount(12);
    }
}

