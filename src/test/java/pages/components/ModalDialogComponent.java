package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalDialogComponent {

    public void checkHeading (String text) {
        $(".modal-title").shouldHave(text(text));
    }

    public void checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
    }
}
