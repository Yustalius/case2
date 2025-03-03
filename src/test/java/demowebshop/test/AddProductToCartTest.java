package demowebshop.test;

import demowebshop.pages.ProductCatalogPage;
import org.junit.jupiter.api.Test;

public class AddProductToCartTest extends TestBase {

    private static final String POLKA_DOT_PRODUCT = "50's Rockabilly Polka Dot Top JR Plus Size";
    protected ProductCatalogPage productCatalogPage = new ProductCatalogPage();
    @Test
    void addProductToCartTest() {
        mainPage
                .clickOnProduct("Apparel & Shoes")
                .clickProductName(POLKA_DOT_PRODUCT)
                .verifyProductNameInUpperCase(POLKA_DOT_PRODUCT)
                .clickAddToCartButton()
                .clickToCartButton()
                .refreshCart()
                .verifyCartQuantity("(1)")
                .selectItemInCart()
                .updateCart()
                .verifyCartQuantity("(0)");
    }
}
