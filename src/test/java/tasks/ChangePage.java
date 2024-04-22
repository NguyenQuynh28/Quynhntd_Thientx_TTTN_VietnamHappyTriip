package tasks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import ui.AdminPage;

public class ChangePage implements Performable {
    private String value;
    private int maxAttempts; // Số lần tối đa thực hiện click
    private String status;
    private String route;

    public ChangePage(String value, int maxAttempts, String status, String route) {
        this.value = value;
        this.maxAttempts = maxAttempts;
        this.status = status;
        this.route = route;
    }

    public static ChangePage change(String value, int maxAttempts, String status, String route) {
        return Tasks.instrumented(ChangePage.class, value, maxAttempts, status, route);
    }

    @Step("{0} moves to the desired page")
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 1; i <= maxAttempts; i++) {
            boolean check = Text.of(AdminPage.LBL_ROUTE(status, route)).answeredBy(actor).equals(value);
            if (check) {
                break;
            } else {
                actor.attemptsTo(
                        Click.on(AdminPage.BTN_CHANGE_PAGES)
                );
            }
        }
    }
}
