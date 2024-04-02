package ui;

import net.serenitybdd.screenplay.targets.Target;

public class AdminPage {
    public static final Target NAV_BTN_BOOKING_CONFIRMATION = Target.the("Button navigate to booking confirmation")
            .locatedBy("//div[@aria-label='Booking Confirmation']");
    public static final Target TITLE_BOOKING_CONFIRMATION = Target.the("Title booking confirmation")
            .locatedBy("//div[@class='booking-confirmation']//h2");
}
