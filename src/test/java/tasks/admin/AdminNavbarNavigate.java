package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.AdminPage;

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
}
