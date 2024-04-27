package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.LoginPage;
import untils.LoadConfig;

public class Login_Partner30 implements Performable {
    private final String auth;

    public Login_Partner30(String auth) {
        this.auth = auth;
    }

    public static Login_Partner30 toPartner30Page() {
        return Tasks.instrumented(Login_Partner30.class, "partner");
    }

    @Step("{0} login with auth page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (auth.contains("partner")) {
            actor.attemptsTo(
                    Click.on(LoginPage.BTN_CHOOSE_OPTION_LOGIN),
                    Click.on(LoginPage.BTN_OPTION_LOGIN.of(auth))
            );
        }

        //Input data to username and password
        actor.attemptsTo(
                Enter.theValue(LoadConfig.getUserNamePartner30(auth)).into(LoginPage.TXT_USER_NAME),
                Enter.theValue(LoadConfig.getPasswordPartner30(auth)).into(LoginPage.TXT_PASSWORD)
                        .then(Click.on(LoginPage.BTN_LOGIN))
        );
    }

}
