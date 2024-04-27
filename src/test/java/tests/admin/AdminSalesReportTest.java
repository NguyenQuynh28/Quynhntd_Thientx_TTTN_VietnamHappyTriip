package tests.admin;

import com.github.romankh3.image.comparison.model.ImageComparisonState;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.CompareImage;
import tasks.Login;
import tasks.Logout;
import tasks.Navigate;
import tasks.admin.AdminBookingConfirm;
import tasks.admin.AdminChooseRoute;
import tasks.admin.AdminNavbarNavigate;
import tasks.admin.AdminRouteManagement;
import tasks.partner.PartnerRouteManagement;
import tasks.passenger.PassengerBookingHistory;
import tests.CommonTest;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminSalesReportTest extends CommonTest {

    @Test
    @Tag("Admin_Test45")
    @Title("Test45: The system displays a revenue chart by month.")
    public void test45() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a route then logout account
        andThat(client).attemptsTo(
               Login.toPartnerPage()
                       .then(PartnerRouteManagement.createRouteSuccess())
                       .then(Logout.account())
        );
        andThat(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement()
                        .then(AdminChooseRoute.withStatusPending("DaNangCity - HoiAnCity"))
                        .then(AdminRouteManagement.yesAcceptRoute())
        );
        andThat(client).attemptsTo(
                Navigate.toLoginClientPage()
                        .then(Login.toPassengerPage())
                        .then(PassengerBookingHistory.bookingSuccess())
        );
        andThat(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation()
                        .then(AdminBookingConfirm.bookingConfirm("DaNangCity - HoiAnCity"))
        );
        //1.Click on the "Sales Report" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toSalesReport());
        //2. Click on the "Revenue of month" tab.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_TAB_OF_MONTH));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(CompareImage.withTargetAndExpected(AdminPage.TABLE_REVENUE_OF_MONTH, "imageOfMonthBefore")).isEqualTo(ImageComparisonState.MISMATCH)
        );
    }

}
