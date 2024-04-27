package tests.passenger;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.CountRoute;
import tasks.ChangePage;
import tasks.Login;
import tasks.passenger.PassengerBookingHistory;
import tasks.passenger.PassengerNavbarNavigate;
import tests.CommonTest;
import ui.PassengerPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PassengerBookingHistoryTest")
public class PassengerBookingHistoryTest extends CommonTest {
    /**
     * Booking Ticket
     */
    @Test
    @Tag("Passenger_Test29")
    @Title("Passenger_Test29: Red border is displayed when From is left blank")
    public void Passenger_test29() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Do not select the "From"
        when(client).attemptsTo(
                Click.on(PassengerPage.DRP_CHOOSE_ADDRESS.of("From")),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.DRP_BORDER_FROM.resolveFor(client).getCssValue("border-color")).isEqualTo("rgb(226, 76, 76)")
        );
    }

    @Test
    @Tag("Passenger_Test30")
    @Title("Passenger_Test30: Red border is displayed when To is left blank")
    public void Passenger_test30() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Do not select the "To"
        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                Click.on(PassengerPage.DRP_CHOOSE_ADDRESS.of("To")),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.DRP_BORDER_TO.resolveFor(client).getCssValue("border-color")).isEqualTo("rgb(226, 76, 76)")
        );
    }

    @Test
    @Tag("Passenger_Test31")
    @Title("Passenger_Test31: Red border is displayed when Depart date is left blank")
    public void Passenger_test31() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Do not select the "Depart date"
        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                Click.on(PassengerPage.TXT_DEPART_DATE),
                Click.on(PassengerPage.BTN_CLEAR),
                PassengerBookingHistory.ClickSearchTicket(),
                WaitABit.inSecond(2)
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.TXT_BORDER_DEPART_DATE.resolveFor(client).getCssValue("border-color")).isEqualTo("rgb(226, 76, 76)")
        );
    }

    @Test
    @Tag("Passenger_Test32")
    @Title("Passenger_Test32: Red border is displayed when Depart date is wrong format")
    public void Passenger_test32() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Depart date is wrong format
        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30/04/2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.TXT_BORDER_DEPART_DATE.resolveFor(client).getCssValue("border-color")).isEqualTo("rgb(226, 76, 76)")
        );
    }

    @Test
    @Tag("Passenger_Test33")
    @Title("Passenger_Test33: Ticket search results are displayed")
    public void Passenger_test33() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.MESSAGE_RESULT).isDisplayed()
        );
    }

    @Test
    @Tag("Passenger_Test34")
    @Title("Passenger_Test34: The ticket not available message is displayed when selecting a to that has not been created")
    public void Passenger_test34() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Ngãi"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_NO_TICKETS)).isEqualTo("Sorry, there is no ticket available on this date"));
    }

    @Test
    @Tag("Passenger_Test35")
    @Title("Passenger_Test35: The ticket not available message is displayed when selecting a form that has not been created")
    public void Passenger_test35() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Thừa Thiên Huế"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_NO_TICKETS)).isEqualTo("Sorry, there is no ticket available on this date"));
    }

    @Test
    @Tag("Passenger_Test36")
    @Title("Passenger_Test36: Unavailable ticket message displays when selecting an overdue date")
    public void Passenger_test36() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Bà Rịa - Vũng Tàu"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_NO_TICKETS)).isEqualTo("Sorry, there is no ticket available on this date"));
    }

    @Test
    @Tag("Passenger_Test37")
    @Title("Passenger_Test37: View Detail is displayed")
    public void Passenger_test37() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                Click.on(PassengerPage.BTN_VIEW_DETAIL.of("Đà Nẵng - Hội An"))
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.MESSAGE_UTILITIES_VEHICLE).isDisplayed());
    }

    @Test
    @Tag("Passenger_Test38")
    @Title("Passenger_Test38: Hide Detail is displayed")
    public void Passenger_test38() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                Click.on(PassengerPage.BTN_VIEW_DETAIL.of("Đà Nẵng - Hội An")),
                Click.on(PassengerPage.BTN_HIDE_DETAIL.of("Đà Nẵng - Hội An"))
        );
        then(client).attemptsTo(
                Ensure.that(PassengerPage.MESSAGE_UTILITIES_VEHICLE).isNotDisplayed());
    }

    @Test
    @Tag("Passenger_Test39")
    @Title("Passenger_Test39: Page Your Booking is displayed")
    public void Passenger_test39() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                PassengerBookingHistory.clickBookingNow("Đà Nẵng - Hội An")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_YOUR_BOOKING)).isEqualTo("Your Booking"));
    }

    @Test
    @Tag("Passenger_Test40")
    @Title("Passenger_Test40: Payment method is displayed")
    public void Passenger_test40() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                PassengerBookingHistory.clickBookingNow("Đà Nẵng - Hội An")
                        .then(
                                PassengerBookingHistory.chooseSeatAndCheckout("B1")
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_PAYMENT_METHOD)).isEqualTo("Payment method"));
    }

    @Test
    @Tag("Passenger_Test41")
    @Title("Passenger_Test41: A successful cash payment message is displayed")
    public void Passenger_test41() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                PassengerBookingHistory.clickBookingNow("Đà Nẵng - Hội An"),
                PassengerBookingHistory.chooseSeatAndCheckout("B2")
                        .then(
                                Click.on(PassengerPage.BTN_CASH)
                        )
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_SUCCESS)).contains("Booking pending successfully! Please come to the agency to complete the payment.")
        );
    }

    @Test
    @Tag("Passenger_Test42")
    @Title("Passenger_Test42: Page select payment method is displayed")
    public void Passenger_test42() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                PassengerBookingHistory.clickBookingNow("Đà Nẵng - Hội An"),
                PassengerBookingHistory.chooseSeatAndCheckout("B2")
                        .then(
                                Click.on(PassengerPage.BTN_CREDIT_AND_DEBIT_CARD)
                        )
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_CHOOSE_PAYMENT_METHOD)).contains("Chọn phương thức thanh toán")
        );
    }

    /**
     * Search ticket
     */
    @Test
    @Tag("Passenger_Test43")
    @Title("Passenger_Test43: The booing history is displayed")
    public void Passenger_test43() {
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory()

        );
        then(client).should(
                seeThat("The Booking History is displayed", the(PassengerPage.TITLE_BOOKING_HISTORY), isVisible())
        );
    }

    @Test
    @Tag("Passenger_Test44")
    @Title("Passenger_Test44: Text no booking histories found is displayed")
    public void Passenger_test44() {
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory(),
                PassengerBookingHistory.searchTicket("tRI31G")

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_NO_BOOKING_HISTORY)).isEqualTo("No booking histories found.")
        );
    }

    @Test
    @Tag("Passenger_Test45")
    @Title("Passenger_Test45: The searched information is displayed")
    public void Passenger_test45() {
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory(),
                PassengerBookingHistory.searchTicket("NPU9P6L8")

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.TXT_CODE.of("NPU9P6L8"))).isEqualTo("NPU9P6L8")
        );
    }

    @Test
    @Tag("Passenger_Test46")
    @Title("Passenger_Test46: All information is displayed")
    public void Passenger_test46() {
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory()
        );
        then(client).should(
                seeThat("All routes are displayed after clicking the clear button", CountRoute.countRoute("codeOfTicket", "Showing 46 to 50"))
        );
    }

    /**
     * View booked ticket
     */
    @Test
    @Tag("Passenger_Test47")
    @Title("Passenger_Test47: Check status MONEYPENDING")
    public void Passenger_test47() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerBookingHistory.selectFrom("Đà Nẵng"),
                PassengerBookingHistory.selectTo("Quảng Nam"),
                PassengerBookingHistory.inputDepartDate("30-04-2024"),
                PassengerBookingHistory.ClickSearchTicket(),
                PassengerBookingHistory.clickBookingNow("Đà Nẵng - Hội An"),
                PassengerBookingHistory.chooseSeatAndCheckout("B2"),
                Click.on(PassengerPage.BTN_CASH),
                WaitABit.inSecond(3)
        );
        and(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory(),
                ChangePage.change("BFeDcpCG", 20, "MONEYPENDING", "BFeDcpCG")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.TXT_TAG.of("BFeDcpCG"))).isEqualTo("MONEYPENDING")
        );
    }

    @Test
    @Tag("Passenger_Test48")
    @Title("Passenger_Test48: Check status SUCCESS")
    public void Passenger_test48() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory(),
                ChangePage.change("pUemNhpp", 20, "SUCCESS", "pUemNhpp")

        );
        // Passenger check status
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.TXT_TAG.of("pUemNhpp"))).isEqualTo("SUCCESS")
        );
    }

    @Test
    @Tag("Passenger_Test49")
    @Title("Passenger_Test49: Check status PENDING")
    public void Passenger_test49() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        when(client).attemptsTo(
                PassengerNavbarNavigate.toBookingHistory(),
                ChangePage.change("NPU9P6L8", 20, "PENDING", "NPU9P6L8")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.TXT_TAG.of("NPU9P6L8"))).isEqualTo("PENDING")
        );
    }
}
