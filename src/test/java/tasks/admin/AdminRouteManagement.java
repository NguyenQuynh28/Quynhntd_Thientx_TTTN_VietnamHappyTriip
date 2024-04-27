package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.Actions;
import ui.AdminPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class AdminRouteManagement {
    public static Performable searchRoute(String value) {
        return Task.where("Search route information",
                Actions.inputData(AdminPage.TXT_SEARCH, value)
        );
    }

    public static Performable chooseRoute(String status, String route) {
        return Task.where("Choose Route",
                Click.on(AdminPage.LBL_ROUTE(status, route))
        );
    }

    public static Performable confirmRoute(String value) {
        return Task.where("Confirm Route",
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of(value))
        );
    }

    public static Performable reconfirmRoute(String value) {
        return Task.where("Confirm the Route again",
                Click.on(AdminPage.BTN_RECONFIRM.of(value))
        );
    }

    public static Performable acceptRoute(){
        return Task.where("{0} accept route",
                Click.on(AdminPage.BTN_ACCEPT)
        );
    }
    public static Performable noAcceptRoute(){
        return Task.where("{0} no accept route",
                AdminPartnerManagement.acceptPartner()
                        .then(Click.on(AdminPage.BTN_NO))
        );
    }
    public static Performable yesAcceptRoute(){
        return Task.where("{0} yes accept route",
                AdminRouteManagement.acceptRoute()
                        .then(Click.on(AdminPage.BTN_YES)),
                WaitABit.inSecond(10),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isNotVisible()).forNoMoreThan(120).seconds()
        );
    }
}
