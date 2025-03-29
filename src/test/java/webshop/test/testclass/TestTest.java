package webshop.test.testclass;

import api.webshop.helpers.TestBase;
import api.webshop.test.uiclient.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("api/ui")
public class TestTest extends TestBase {
    private final SearchWebShop uiClient = new SearchWebShop();
    private final FilterProduct filterProduct = new FilterProduct();
    private final AddingProduct addingProduct = new AddingProduct();
    private final LogoutUser logoutUser = new LogoutUser();

    @Test
    @DisplayName("Проверка поиска по магазину")
    void searchToWebShopTest() {
        uiClient.searchToWebShop();
    }

    @Test
    @DisplayName("Фильтрация продукта по цене")
    void filterProductsTest() {
        filterProduct.filterProductsByPrice();
    }

    @Test
    @DisplayName("Добавление продукта в список желаний")
    void addingProductToYourWishlistTest() {
        addingProduct.addingProductToYourWishlist();
    }

    @Test
    @DisplayName("Выход из аккаунта")
    void logoutTest() {
        logoutUser.logout();
    }
}
