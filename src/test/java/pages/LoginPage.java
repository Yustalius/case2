package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

  private final SelenideElement setLoginInInput = $("#login_field"),
      setPasswordInput = $("#password");

  public LoginPage setLogin(String value) {
    setLoginInInput.setValue(value);

    return this;
  }

  public LoginPage setPassword(String value) {
    setPasswordInput.setValue(value).pressEnter();

    return this;
  }

  public MainPage clickSignInButton() {
    // тут нажатие на кнопку Sign In

    return new MainPage();
  }
}
