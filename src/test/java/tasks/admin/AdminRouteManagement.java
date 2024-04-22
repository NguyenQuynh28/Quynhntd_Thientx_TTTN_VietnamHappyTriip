package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.AdminPage;

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

}
