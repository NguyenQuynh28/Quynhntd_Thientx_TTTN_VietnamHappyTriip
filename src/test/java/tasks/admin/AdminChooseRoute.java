package tasks.admin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AdminPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdminChooseRoute implements Performable {
    private final String status;
    private final String name;

    public AdminChooseRoute(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public static AdminChooseRoute withStatusPending(String name) {
        return Tasks.instrumented(AdminChooseRoute.class, "PENDING", name);
    }

    public static AdminChooseRoute withStatusAccept(String name) {
        return Tasks.instrumented(AdminChooseRoute.class, "ACCEPTED", name);
    }

    public static AdminChooseRoute withStatusDeny(String name) {
        return Tasks.instrumented(AdminChooseRoute.class, "DENIED", name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitABit.inSecond(5));
        while (true) {
            if (AdminPage.OPTION_ROUTE_IN_LIST(status, name).resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        MoveMouse.to(AdminPage.OPTION_ROUTE_IN_LIST(status, name)),
                        Click.on(AdminPage.OPTION_ROUTE_IN_LIST(status, name))
                );
                break;
            } else {
                actor.attemptsTo(Click.on(AdminPage.BTN_NEXT_IN_LIST));
            }
        }
        WaitUntil.the(AdminPage.POPUP_PARTNER_DETAIL, isVisible()).forNoMoreThan(120).seconds();
    }
}
