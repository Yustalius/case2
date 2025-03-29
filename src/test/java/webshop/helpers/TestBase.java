package webshop.helpers;

import api.webshop.test.apiclient.ApiClient;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static todo.helpers.RestAssuredSpec.setupRestAssured;

public class TestBase {
    private static final String MINIMUM_WEBSITE_CONTENT_URL = "/Themes/DefaultClean/Content/images/logo.png";
    private static final String WEBSITE_URL = "https://demowebshop.tricentis.com";
    private static final String cookieName = "NOPCOMMERCE.AUTH";
    private final ApiClient client = new ApiClient();
    private final Cookies cookies = new Cookies();

    @BeforeEach
    public void setUp() {
        String autoCookie = client.login();
        open(MINIMUM_WEBSITE_CONTENT_URL);
        cookies.addCookies(cookieName, autoCookie);
    }

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = WEBSITE_URL;
        setupRestAssured();
    }
}
