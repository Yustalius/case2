package my_progect;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.RepositoryPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideRepositorySearchPageObjects {

    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        Configuration.holdBrowserOpen = true;

        new RepositoryPage().openPage();

        new RepositoryPage().ClickButtonSignIn();
        new RepositoryPage().setLogin("awerinzh@yandex.ru");
        new RepositoryPage().setPassword("averin228337");
        new RepositoryPage().ClickTheInputField();
        new RepositoryPage().EnterInTheField("selenide");
        new RepositoryPage().ClickOnTheFirstLink();
        new RepositoryPage().setShouldHave("selenide / selenide");
        new RepositoryPage().HoverOverFirstContributor();
        new RepositoryPage().VerifyContributorName("Andrei Solntsev");
        new RepositoryPage().ClickOnTheIcon();
        new RepositoryPage().ClickSignOut();
        new RepositoryPage().ClickSignOutAgain();


    }



}
