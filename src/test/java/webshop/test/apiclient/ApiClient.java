package webshop.test.apiclient;

import api.demowebshop.model.AddToCartResponse;
import api.yustalius.helpers.PropertiesHelper;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    PropertiesHelper props = new PropertiesHelper("src/test/resources/demowebshop.properties");
    RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("https://demowebshop.tricentis.com")
            .build();
    private String email = props.getProperty("email");
    private String password = props.getProperty("password");


    @Step("Логин пользователя")
    public String login() {

        return RestAssured.given(spec)
                .log().all()
                .formParams("Email", email)
                .formParams("Password", password)
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .log().all()
                .extract().cookie("NOPCOMMERCE.AUTH");
    }

    @Step("Добавление продукта в корзину")
    public AddToCartResponse addProductToCart(String productName) {


        return RestAssured.given(spec)
                .cookie("NOPCOMMERCE.AUTH", login())
                .contentType("application/x-www-form-urlencoded")
                .formParams(productName, "1")
                .formParams("addtocart_5.EnteredQuantity", "1")
                .post("/addproducttocart/details/5/1")
                .then()
                .statusCode(200)
                .log().all()
                .extract().as(AddToCartResponse.class);
    }
}
