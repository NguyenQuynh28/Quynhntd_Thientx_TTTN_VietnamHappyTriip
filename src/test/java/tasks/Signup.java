package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.SignupPage;

public class Signup implements Performable {
    private final String auth;

    public Signup(String auth) {
        this.auth = auth;
    }

    public static Signup toSignupPartner() {
        return Tasks.instrumented(Signup.class, "partner");
    }

    public static Signup toSignupPassenger() {
        return Tasks.instrumented(Signup.class, "passenger");
    }

    @Step("{0} signup with auth page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (auth.contains("partner") || auth.contains("passenger")) {
            actor.attemptsTo(
                    Click.on(SignupPage.BTN_CHOOSE_OPTION_SIGNUP),
                    Click.on(SignupPage.BTN_OPTION_SIGNUP.of(auth))
            );
        }
    }
}
