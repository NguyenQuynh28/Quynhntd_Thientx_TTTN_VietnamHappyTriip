package tasks.passenger;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import ui.PassengerPage;

public class PassengerNavbarNavigate {
    public static Performable toBookingHistory() {
        return Task.where("{0} navigate to Booking History",
                Click.on(PassengerPage.BTN_CUSTOM_USER),
                Click.on(PassengerPage.BTN_MANAGEMENT),
                Click.on(PassengerPage.NAV_BTN_BOOKING_HISTORY)
        );
    }

    public static Performable toPassengerManagement() {
        return Task.where("{0} navigate to Passenger Management",
                Click.on(PassengerPage.BTN_CUSTOM_USER),
                Click.on(PassengerPage.BTN_MANAGEMENT),
                Click.on(PassengerPage.NAV_BTN_PASSENGER_MANAGEMENT)
        );
    }
}
