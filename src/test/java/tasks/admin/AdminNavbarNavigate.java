package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AdminPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AdminNavbarNavigate {
    public static Performable toBookingConfirmation() {
        return Task.where("{0} navigate to Booking Confirmation",
                Click.on(AdminPage.NAV_BTN_BOOKING_CONFIRMATION)
        );
    }
    public static Performable toProfileSettings() {
        return Task.where("{0} navigate to Profile & Settings",
                Click.on(AdminPage.NAV_BTN_PROFILE_SETTINGS)
        );
    }
    public static Performable toAddNewUser() {
        return Task.where("{0} navigate to Add New User Page",
                Click.on(AdminPage.BTN_ADD_USER)
        );
    }
    public static Performable toPoiAndStations() {
        return Task.where("{0} navigate to Poi & Stations",
                Click.on(AdminPage.NAV_BTN_POI_STATIONS)
                        .then(Click.on(AdminPage.BTN_ADD_POI_STATIONS)),
                WaitUntil.the(AdminPage.TITLE_POI_STATIONS, isVisible()).forNoMoreThan(30).seconds()
        );
    }

    public static Performable toRouteManagement() {
        return Task.where("{0} navigate to Route Confirmation",
                Click.on(AdminPage.NAV_BTN_ROUTE_MANAGEMENT)
        );
    }
    public static Performable toPartnerManagement() {
        return Task.where("{0} navigate to partner management",
                Click.on(AdminPage.NAV_BTN_PARTNER_MANAGEMENT)
        );
    }

    public static Performable toSalesReport() {
        return Task.where("{0} navigate to sales report",
                Click.on(AdminPage.NAV_BTN_SALES_REPORT)
        );
    }
}
