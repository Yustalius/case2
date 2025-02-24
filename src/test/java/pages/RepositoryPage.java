package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RepositoryPage {
    private SelenideElement
            setLoginInInput = $("#login_field"),
            setPasswordInput = $("#password");

    public RepositoryPage openPage() {
        open("https://github.com/");

        return this;
    }

    public RepositoryPage clickButtonSignIn() {
        $(".HeaderMenu-link-wrap").click();

        return this;
    }

   public RepositoryPage setLogin(String value) {
       setLoginInInput.setValue(value);

       return this;
   }

    public RepositoryPage setPassword(String value) {
        setPasswordInput.setValue(value).pressEnter();

        return this;
    }

    public RepositoryPage clickTheInputField() {
        $(".placeholder").click();

        return this;
    }

    public RepositoryPage enterInTheField(String value) {
        $("#query-builder-test").setValue(value).pressEnter();

        return this;
    }

    public RepositoryPage clickOnTheFirstLink() {
        $(".search-title").click();

        return this;
    }

    public RepositoryPage setShouldHave(String value) {
        $(".position-relative").shouldHave(text(value));

        return this;
    }

    public RepositoryPage hoverOverFirstContributor() {
        $(".BorderGrid")
                .$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();

        return this;

    }

    public RepositoryPage verifyContributorName(String value) {
        $(".Truncate-text--expandable").shouldHave(text(value));

        return this;

    }

    public RepositoryPage clickOnTheIcon() {
        $(".AppHeader-user").click();

        return this;
    }


    public RepositoryPage clickSignOut() {
        $(byTagAndText("span", "Sign out")).click();

        return this;
    }

    public RepositoryPage clickSignOutAgain() {
        $(".inline-form").click();

        return this;
    }




}


