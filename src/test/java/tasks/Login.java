package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPage;
import untils.LoadConfig;

public class Login implements Performable {
    private final String auth;

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
                    Click.on(LoginPage.BTN_CHOOSE_OPTION_LOGIN),
                    Click.on(LoginPage.BTN_OPTION_LOGIN.of(auth))
            );
        }

        //Input data to username and password
        actor.attemptsTo(
                Enter.theValue(LoadConfig.getUserName(auth)).into(LoginPage.TXT_USER_NAME),
                Enter.theValue(LoadConfig.getPassword(auth)).into(LoginPage.TXT_PASSWORD)
                        .then(Click.on(LoginPage.BTN_LOGIN))
        );
    }
}
