package demowebshop.test;

import demowebshop.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

    public class CheckingElementsOnPagesTest extends TestBase {

        private final MainPage mainPage = new MainPage();

        @Test
        @DisplayName("Проверка отображения 4, 8 и 12 продуктов на странице")
        void verifyProductsPerPage() {
            mainPage
                    .clickOnProduct("Apparel & Shoes")
                    .selectProductsPerPage(4)
                    .verifyProductsCount(4)
                    .selectProductsPerPage(8)
                    .verifyProductsCount(8)
                    .selectProductsPerPage(12)
                    .verifyProductsCount(12);
        }
    }

