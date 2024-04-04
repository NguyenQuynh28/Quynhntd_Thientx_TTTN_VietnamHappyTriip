package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.PartnerPage;

public class PartnerNavbarNavigate {
    public static Performable toTransportManagement() {
        return Task.where("{0} navigate to Transport Management",
                Click.on(PartnerPage.NAV_BTN_NAVIGATE.of("Transport Management"))
        );
    }

    public static Performable toRouteManagement() {
        return Task.where("{0} navigate to Route Management",
                Click.on(PartnerPage.NAV_BTN_NAVIGATE.of("Route Management"))
        );
    }
}
