package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import tasks.partner.SignupPartner;
import ui.LoginPage;
import untils.LoadConfig;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class Login implements Performable {
    private final String auth;
    private static Boolean information = false;

    public Login(String auth) {
        this.auth = auth;
    }

    public static Login toAdminPage() {
        return Tasks.instrumented(Login.class, "admin");
    }

    public static Login toPartnerPage() {
        return Tasks.instrumented(Login.class, "partner");
    }

    public static Login toPassengerPage() {
        return Tasks.instrumented(Login.class, "passenger");
    }

    @Step("{0} login with auth page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (auth.contains("partner") || auth.contains("passenger")) {
            actor.attemptsTo(
                    Check.whether(the(LoginPage.LBL_TITLE_LOGIN), isNotVisible())
                            .andIfSo(
                                    WaitUntil.the(LoginPage.BTN_CHOOSE_OPTION_LOGIN, isVisible()).forNoMoreThan(120).seconds(),
                                    Click.on(LoginPage.BTN_CHOOSE_OPTION_LOGIN),
                                    Click.on(LoginPage.BTN_OPTION_LOGIN.of(auth))
                            )
            );
        }
        //Input data to username and password
        if (information) {
            actor.attemptsTo(
                    Enter.theValue(SignupPartner.getUserName()).into(LoginPage.TXT_USER_NAME),
                    Enter.theValue(SignupPartner.getUserName()).into(LoginPage.TXT_PASSWORD)
            );
        } else {
            actor.attemptsTo(
                    Enter.theValue(LoadConfig.getUserName(auth)).into(LoginPage.TXT_USER_NAME),
                    Enter.theValue(LoadConfig.getPassword(auth)).into(LoginPage.TXT_PASSWORD)
            );
        }
        actor.attemptsTo(
                Click.on(LoginPage.BTN_LOGIN)
        );
    }

    public Login withNewPartner() {
        Login.information = true;
        return this;
    }
}
