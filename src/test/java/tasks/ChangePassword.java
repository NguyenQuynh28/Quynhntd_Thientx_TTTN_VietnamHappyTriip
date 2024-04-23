package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import ui.ChangePasswordPopup;

public class ChangePassword implements Performable {
    private final String auth;
    public ChangePassword(String auth) {
        this.auth = auth;
    }
    public static ChangePassword toChangePasswordPartner(){
        return Tasks.instrumented(ChangePassword.class, "partner");
    }
    public static ChangePassword toChangePasswordPassenger(){
        return Tasks.instrumented(ChangePassword.class, "passenger");
    }
    @Step("{0} change password")
    @Override
    public <T extends Actor> void performAs(T actor) {
        if (auth.contains("partner") || auth.contains("passenger")) {
            actor.attemptsTo(
                    Click.on(ChangePasswordPopup.BTN_CHANGE_PASSWORD)
            );
        }

    }
}
