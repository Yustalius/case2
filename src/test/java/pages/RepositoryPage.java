package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RepositoryPage {

    public void openPage() {
        open("https://github.com/");
    }

    public void ClickButtonSignIn() {
        $(".HeaderMenu-link-wrap").click();
    }

   public void setLogin(String value) {
       $("#login_field").setValue(value);
   }

    public void setPassword(String value) {
        $("#password").setValue(value).pressEnter();
    }

    public void ClickTheInputField() {
        $(".placeholder").click();
    }

    public void EnterInTheField(String value) {
        $("#query-builder-test").setValue(value).pressEnter();
    }

    public void ClickOnTheFirstLink() {
        $(".search-title").click();
    }

    public void setShouldHave(String value) {
        $(".position-relative").shouldHave(text(value));
    }

    public void HoverOverFirstContributor() {
        $(".BorderGrid")
                .$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();

    }

    public void VerifyContributorName(String value) {
        $(".Truncate-text--expandable").shouldHave(text(value));

    }

    public void ClickOnTheIcon() {
        $(".AppHeader-user").click();
    }


    public void ClickSignOut() {
        $(byTagAndText("span", "Sign out")).click();
    }

    public void ClickSignOutAgain() {
        $(".inline-form").click();
    }




}


