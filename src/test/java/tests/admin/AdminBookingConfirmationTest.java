package tests.admin;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import tests.CommonTest;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("AdminBookingConfirmationTest")
public class AdminBookingConfirmationTest extends CommonTest {
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
}
