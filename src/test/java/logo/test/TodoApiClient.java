package logo.test;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import logo.helpers.PropertiesHelper;
import logo.model.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class TodoApiClient {
    private final PropertiesHelper props = new PropertiesHelper("src/test/java/resources/testdata.properties");
    private final RequestSpecification spec = new RequestSpecBuilder()
            .setBaseUri("http://2.59.41.2:4300/")
            .setContentType(JSON)
            .build();
    private final Faker faker = new Faker();
    private final String
            email = faker.internet().emailAddress(),
            password = faker.internet().password();

    public LogoAuthResponse register() {
        LogoAuthResponse response = register(email, password);
        props.setProperty("USER_ID", String.valueOf(response.getUser().getId()));

        return response;
    }

    @Step("Регистрация пользователя")
    public LogoAuthResponse register(String email, String password) {
        LogoAuthRequest request = new LogoAuthRequest();
        request.setEmail(email);
        request.setPassword(password);

        return given(spec)
                .body(request)
                .when()
                .post("/api/registration")
                .then()
                .statusCode(201)
                .extract().as(LogoAuthResponse.class);
    }

    @Step("Логин пользователя")
    public LogoAuthResponse login(String email, String password) {
        LogoAuthRequest request = new LogoAuthRequest();
        request.setEmail(email);
        request.setPassword(password);

        return given(spec)
                .body(request)
                .when()
                .post("/api/login")
                .then()
                .statusCode(201)
                .extract().as(LogoAuthResponse.class);
    }

    @Step("Создание задачи")
    public LogoTodoResponse createTask(int userId, String title) {
        LogoTodoRequest request = new LogoTodoRequest();
        request.setUserId(userId);
        request.setTitle(title);

        return given(spec)
                .header("Authorization", "Bearer " + login(email, password).getAccessToken())
                .body(request)
                .when()
                .post("/api/todos")
                .then()
                .statusCode(201)
                .extract().as(LogoTodoResponse.class);
    }

    @Step("Обновление задачи")
    public LogoTodoResponse updateTask(int todoId, int userId, String title, boolean completed) {
        UpdateTodoRequest request = new UpdateTodoRequest();
        request.setUserId(userId);
        request.setTitle(title);
        request.setCompleted(completed);

        return given(spec)
                .header("Authorization", "Bearer " + login(email, password).getAccessToken())
                .body(request)
                .when()
                .put("/api/todos/" + todoId)
                .then()
                .statusCode(200)
                .extract().as(LogoTodoResponse.class);
    }

    @Step("Удаление задачи")
    public void deleteTask(int userId, int todoId) {
        given(spec)
                .header("Authorization", "Bearer " + login(email, password).getAccessToken())
                .when()
                .delete("/api/todos/" + userId + "/" + todoId)
                .then()
                .statusCode(200)
                .extract().as(DeleteTodoResponse.class);

    }
}
