package logo.test;

import com.github.javafaker.Faker;
import logo.helpers.PropertiesHelper;
import logo.helpers.TestBase;
import logo.model.LogoAuthResponse;
import logo.model.LogoTodoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoTest extends TestBase {
    private final PropertiesHelper props = new PropertiesHelper("src/test/java/resources/testdata.properties");
    private final TodoApiClient client = new TodoApiClient();
    private final Faker faker = new Faker();

    @BeforeEach
    void setUp() {
        client.register();
    }

    @Test
    @DisplayName("Регистрация нового пользователя")
    void registerTest() {
        LogoAuthResponse response = client.register(faker.internet().emailAddress(), faker.internet().password());

        assertThat(response.getAccessToken()).isNotNull();
    }

    @Test
    @DisplayName("Логин пользователя")
    void loginTest() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        client.register(email, password);
        LogoAuthResponse response = client.login(email, password);

        assertThat(response.getAccessToken()).isNotNull();
    }

    @Test
    @DisplayName("Создание задачи")
    void createTodoTest() {
        String title = faker.animal().name();
        LogoTodoResponse response = client.createTask(Integer.parseInt(props.getProperty("USER_ID")), title);

        assertThat(response.getTitle()).isEqualTo(title);
    }

    @Test
    @DisplayName("Обновление задачи")
    void updateTodoTest() {
        String title = faker.animal().name();
        LogoTodoResponse task = client.createTask(Integer.parseInt(props.getProperty("USER_ID")), title);

        LogoTodoResponse response= client.updateTask(
                task.getTodoId(),
                task.getUserId(),
               "title",
                false
        );

        assertThat(response.getTitle()).isEqualTo("title");
    }

    @Test
    @DisplayName("Удаление задачи")
    void deletedTodoTest() {
        String title = faker.animal().name();
        LogoTodoResponse response = client.createTask(Integer.parseInt(props.getProperty("USER_ID")), title);

        client.deleteTask(response.getUserId(), response.getTodoId());

        assertThat(response.getTitle()).isEqualTo(title);
    }
}
