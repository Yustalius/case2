package demowebshop.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import demowebshop.pages.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    private static final String MAIN_PAGE_URL = "https://demowebshop.tricentis.com/";
    protected final Faker faker = new Faker();
    protected MainPage mainPage = new MainPage();

    @BeforeAll
    void setUP() {
        Configuration.holdBrowserOpen = true;
    }

    @BeforeEach
    void registerNewUser() {
        Selenide.open(MAIN_PAGE_URL, MainPage.class)
                .clickRegisterButton()
                .clickMaleGender()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .setPassword(faker.internet().password())
                .setConfirmPassword(faker.internet().password())
                .clickRegisterButton()
                .verifyRegistrationSuccessMessage()
                .clickContinueButton()
                .clickOnProduct("Apparel & Shoes");
    }

    @AfterEach
    void logoutUser() {
        mainPage
                .clickLogoutButton();
    }
}
