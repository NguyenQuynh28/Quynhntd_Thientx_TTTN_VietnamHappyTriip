package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.AdminPage;

public class AdminNavbarNavigate {
    public static Performable toBookingConfirmation(){
        return Task.where("{0} navigate to booking confirmation",
                Click.on(AdminPage.NAV_BTN_BOOKING_CONFIRMATION)
        );
    }
}
