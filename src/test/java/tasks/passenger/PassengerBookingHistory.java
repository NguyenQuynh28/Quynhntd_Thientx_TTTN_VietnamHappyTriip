package tasks.passenger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.Actions;
import ui.PassengerPage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PassengerBookingHistory {
    public static Performable selectFrom(String from) {
        return Task.where("Select departure locations",
                Click.on(PassengerPage.DRP_CHOOSE_ADDRESS.of("From")),
                Click.on(PassengerPage.DRP_LIST_ADDRESS.of(from)));
    }

    public static Performable selectTo(String to) {
        return Task.where("Select departure locations",
                Click.on(PassengerPage.DRP_CHOOSE_ADDRESS.of("To")),
                WaitUntil.the(PassengerPage.DRP_LIST_ADDRESS.of(to), isVisible()).forNoMoreThan(30).seconds(),
                Click.on(PassengerPage.DRP_LIST_ADDRESS.of(to))
        );
    }

    public static Performable inputDepartDate(String date) {
        return Task.where("Select departure locations",
                Click.on(PassengerPage.TXT_DEPART_DATE),
                Click.on(PassengerPage.BTN_CLEAR),
                Actions.inputData(PassengerPage.TXT_DEPART_DATE, date)
        );
    }

    public static Performable ClickSearchTicket() {
        return Task.where("Click button Search Ticket",
                Click.on(PassengerPage.BTN_SEARCH_TICKET));
    }

    public static Performable clickBookingNow(String value) {
        return Task.where("Click Booking now to book tickets",
                Click.on(PassengerPage.BTN_BOOKING_NOW.of(value)));
    }

    // Choose and click button checkout
    public static Performable chooseSeatAndCheckout(String value) {
        return Task.where("Click Booking now to book tickets",
                Click.on(PassengerPage.BTN_CHOOSE_SEAT.of(value)),
                Click.on(PassengerPage.BTN_CHECKOUT)
        );
    }

    public static Performable searchTicket(String value){
        return Task.where("Passenger search ticker",
                Actions.inputData(PassengerPage.TXT_SEARCH_KEYWORD, value)
        );
    }



}
