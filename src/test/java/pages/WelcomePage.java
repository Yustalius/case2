package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WelcomePage {

  public WelcomePage openPage() {
    open("https://github.com/");

    return this;
  }

  public LoginPage clickButtonSignIn() {
    $(".HeaderMenu-link-wrap").click();

    return new LoginPage();
  }

}
