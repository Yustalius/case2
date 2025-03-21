package my_progect;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import pages.RepositoryPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideRepositorySearchPageObjects {
    RepositoryPage repositoryPage = new RepositoryPage();
    
    @Test
    void shouldFindSelenideRepositoryAtTheTop() {

        Configuration.holdBrowserOpen = true;

        repositoryPage.openPage()
                .clickButtonSignIn()
                .setLogin("Yustalius")
                .setPassword("F215368479u")
                .clickTheInputField()
                .enterInTheField("selenide")
                .clickOnTheFirstLink()
                .setShouldHave("selenide / selenide")
                .hoverOverFirstContributor()
                .verifyContributorName("Andrei Solntsev")
                .clickOnTheIcon()
                .clickSignOut()
                .clickSignOutAgain();


    }







}



