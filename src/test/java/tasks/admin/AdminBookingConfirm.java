package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.Actions;
import ui.AdminPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class AdminBookingConfirm {
    public static Performable confirmInfoBooking() {
        return Task.where("Confirm Route",
                Click.on(AdminPage.BTN_CONFIRM_BOOKING)
        );
    }

    public static Performable reconfirmInfoBooking(String value) {
        return Task.where("Confirm the Booking again",
                Click.on(AdminPage.BTN_RECONFIRM_BOOKING.of(value))
        );
    }

    public static Performable denyInfoBooking() {
        return Task.where("Confirm Route",
                Click.on(AdminPage.BTN_CANCEL_BOOKING)
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

    public static Performable bookingConfirm() {
        return Task.where("{0} booking confirm",
                Click.on(AdminPage.BTN_CONFIRM),
                AdminBookingConfirm.reconfirmInfoBooking("accept"),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isNotVisible()).forNoMoreThan(70).seconds()
        );
    }
}
