package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Logout {
    public static Performable account() {
        return Task.where("{0} logout account",
                WaitUntil.the(LoginPage.BTN_LOGGED, isVisible()).forNoMoreThan(120).seconds(),
                Click.on(LoginPage.BTN_LOGGED),
                WaitUntil.the(LoginPage.BTN_LOG_OUT, isVisible()).forNoMoreThan(120).seconds()
                        .then(Click.on(LoginPage.BTN_LOG_OUT))
        );
    }
}
