package logo.helpers;

import org.junit.jupiter.api.BeforeAll;

import static logo.helpers.RestAssuredSpec.setupRestAssured;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        setupRestAssured();
    }
}
