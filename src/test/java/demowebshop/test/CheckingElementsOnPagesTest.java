package demowebshop.test;

import demowebshop.pages.MainPage;
import demowebshop.pages.ProductCatalogPage;
import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static com.codeborne.selenide.Selenide.sleep;

public class CheckingElementsOnPagesTest extends TestBase {

    private final MainPage mainPage = new MainPage();

    @Test
    void verifyProductsPerPage() {

        mainPage
                .clickOnProduct("Apparel & Shoes")
                .clickOnTheDropdownList()
                .clickOnFour()
                .checkFourProductsPage()
                .clickOnTheDropdownList()
                .clickOnEight()
                .checkEightProductsPage()
                .clickOnTwelve()
                .checkTwelveProductsPage();






    }
}
