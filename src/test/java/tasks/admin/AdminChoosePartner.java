package tasks.admin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AdminPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdminChoosePartner implements Performable {
    private final String status;
    private final String name;

    public AdminChoosePartner(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public static AdminChoosePartner withStatusPending(String name) {
        return Tasks.instrumented(AdminChoosePartner.class, "PENDING", name);
    }

    public static AdminChoosePartner withStatusAccept(String name) {
        return Tasks.instrumented(AdminChoosePartner.class, "ACCEPTED", name);
    }

    public static AdminChoosePartner withStatusImcompleteData(String name) {
        return Tasks.instrumented(AdminChoosePartner.class, "IMCOMPLETE_DATA", name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitABit.inSecond(5));
        while (true) {
            if (AdminPage.OPTION_PARTNER_IN_LIST(status, name).resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        MoveMouse.to(AdminPage.OPTION_PARTNER_IN_LIST(status, name)),
                        Click.on(AdminPage.OPTION_PARTNER_IN_LIST(status, name))
                );
                break;
            }else {
                actor.attemptsTo(Click.on(AdminPage.BTN_NEXT_IN_LIST));
            }
        }
        WaitUntil.the(AdminPage.POPUP_PARTNER_DETAIL, isVisible()).forNoMoreThan(120).seconds();
    }
}
