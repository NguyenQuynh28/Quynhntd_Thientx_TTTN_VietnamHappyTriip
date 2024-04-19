package tests.admin;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import tasks.passenger.PassengerBookingHistory;
import tests.CommonTest;
import ui.AdminPage;
import ui.PassengerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminBookingConfirmationTest extends CommonTest {
    /**
     * Booking confirmation
     */
    @Test
    @Tag("Admin_Test01")
    @Title("Admin_Test01: The Booking Confirmation is displayed")
    public void admin_test01() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation()
        );
        then(admin).should(
                seeThat("The Booking Confirmation is displayed", the(AdminPage.TITLE_BOOKING_CONFIRMATION), isVisible())
        );
    }

    @Test
    @Tag("Admin_Test02")
    @Title("Admin_Test02: Popup accept booking is displayed")
    public void admin_test02() {
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
        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                Click.on(AdminPage.BTN_CONFIRM.of("pNQRPqRh"))
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_MESSAGE_BOOKING_CONFIRMATION)).isEqualTo("Are you sure that you want to accept this booking?")
        );
    }

}
