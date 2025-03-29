package webshop.test.testclass;

import api.webshop.test.apiclient.ApiClient;
import api.webshop.test.uiclient.DeleteProduct;
import api.webshop.test.uiclient.DoublingsProductCart;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
@Tag("api/ui")
public class Tests extends TestTest {
    private final ApiClient client = new ApiClient();
    private final DeleteProduct deleteProduct = new DeleteProduct();
    private final DoublingsProductCart doublingsProductCart = new DoublingsProductCart();

    @BeforeEach
    void setUP() {
        client.addProductToCart("product_attribute_5_7_1");
        Selenide.refresh();
    }

    @Test
    @DisplayName("Удаление продукта из корзины")
    void deleteProductTest() {
        deleteProduct.deleteProductCart();
    }

    @Test
    @DisplayName("Удваивание продуктов в корзине")
    void DoublingsProductCartTest() {
        doublingsProductCart.doublingsProduct();
    }
}
