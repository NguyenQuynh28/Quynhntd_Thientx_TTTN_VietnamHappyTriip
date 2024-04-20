package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.AdminPage;

public class AdminBookingConfirm {
    public static Performable confirmInfoBooking(String value) {
        return Task.where("Confirm Route",
                Click.on(AdminPage.BTN_CONFIRM_BOOKING.of(value))
        );
    }

    public static Performable reconfirmInfoBooking(String value) {
        return Task.where("Confirm the Booking again",
                Click.on(AdminPage.BTN_RECONFIRM_BOOKING.of(value))
        );
    }

    public static Performable denyInfoBooking(String value) {
        return Task.where("Confirm Route",
                Click.on(AdminPage.BTN_CANCEL_BOOKING.of(value))
        );
    }

    public static Performable searchNamePassengers(String value) {
        return Task.where("Search route information",
                Actions.inputData(AdminPage.TXT_SEARCH, value)
        );
    }

    public static Performable searchCode(String value) {
        return Task.where("Search route information",
                Actions.inputData(AdminPage.TXT_SEARCH, value)
        );
    }
}
