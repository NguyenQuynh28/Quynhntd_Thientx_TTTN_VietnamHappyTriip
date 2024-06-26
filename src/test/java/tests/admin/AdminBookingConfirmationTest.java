package tests.admin;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminBookingConfirm;
import tasks.admin.AdminCountRoute;
import tasks.admin.AdminNavbarNavigate;
import tests.CommonTest;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("AdminBookingConfirmationTest")
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
        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.confirmInfoBooking()
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_MESSAGE_BOOKING_CONFIRMATION)).isEqualTo("Are you sure that you want to accept this booking?")
        );
    }

    @Test
    @Tag("Admin_Test03")
    @Title("Admin_Test03: A successful payment confirmation message is displayed")
    public void admin_test03() {
        givenThat(admin).attemptsTo(Login.toAdminPage());
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.confirmInfoBooking(),
                AdminBookingConfirm.reconfirmInfoBooking("accept")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("This booking is accepted successfully!")
        );
    }

    @Test
    @Tag("Admin_Test04")
    @Title("Admin_Test04: Return to the booking confirmation page after selecting the no button")
    public void admin_test04() {
        givenThat(admin).attemptsTo(Login.toAdminPage());
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.confirmInfoBooking(),
                AdminBookingConfirm.reconfirmInfoBooking("reject")
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TITLE_BOOKING_CONFIRMATION).isDisplayed()
        );
    }

    /**
     * Cancel Booking Confirm
     */
    @Test
    @Tag("Admin_Test05")
    @Title("Admin_Test05: Popup deny booking is displayed")
    public void admin_test05() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.denyInfoBooking()
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_MESSAGE_BOOKING_CONFIRMATION)).isEqualTo("Are you sure that you want to deny this booking?")
        );
    }

    @Test
    @Tag("Admin_Test06")
    @Title("Admin_Test06: A successful deny confirmation message is displayed")
    public void admin_test06() {
        givenThat(admin).attemptsTo(Login.toAdminPage());
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.denyInfoBooking(),
                AdminBookingConfirm.reconfirmInfoBooking("accept")
        );
        then(admin).attemptsTo(
                WaitUntil.the(AdminPage.MESSAGE_SUCCESSFULLY, isVisible()).forNoMoreThan(30).seconds(),
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("This booking is denied successfully!")
        );
    }

    @Test
    @Tag("Admin_Test07")
    @Title("Admin_Test07: Return to the booking confirmation page after selecting the no button")
    public void admin_test07() {
        givenThat(admin).attemptsTo(Login.toAdminPage());
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.denyInfoBooking(),
                AdminBookingConfirm.reconfirmInfoBooking("reject")
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TITLE_BOOKING_CONFIRMATION).isDisplayed()
        );
    }

    /**
     * Search Route
     */
    @Test
    @Tag("Admin_Test08")
    @Title("Admin_Test08: The message No reservations found is displayed after entering an incorrect passenger name")
    public void admin_test08() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.searchNamePassengers("Thien12345")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_NO_RESULTS)).isEqualTo("No bookings found.")
        );
    }

    @Test
    @Tag("Admin_Test09")
    @Title("Admin_Test09: The message No reservations found is displayed after entering an incorrect code")
    public void admin_test09() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.searchCode("tU5SJaCqffffff")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_NO_RESULTS)).isEqualTo("No bookings found.")
        );
    }

    @Test
    @Tag("Admin_Test10")
    @Title("Admin_Test10: Search information is displayed after enter a correct name passenger")
    public void admin_test10() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.searchNamePassengers("ThienTX")
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LBL_NAME_PASSENGER.of("ThienTX")).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test11")
    @Title("Admin_Test11: Search information is displayed after enter a correct code")
    public void admin_test11() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation(),
                AdminBookingConfirm.searchCode("nHNxm7TJ")
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LBL_CODE.of("nHNxm7TJ")).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test12")
    @Title("Admin_Test12: All route information is displayed")
    public void admin_test12() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation()
        );
        then(admin).attemptsTo(
                Ensure.that(AdminCountRoute.countRoute("1OvKFzH7")).isTrue()
        );
    }
}
