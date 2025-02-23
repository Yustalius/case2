package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {
    @Test()
    void fillformTest() {

        Configuration.pageLoadTimeout = 100000;
        open("https://demoqa.com/text-box");
        $(".text-center").shouldHave(text("TextBox"));





    }

}
