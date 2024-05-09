package tests.admin;

import helpers.TakeScreenshot;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.CompareImage;
import tasks.Login;
import tasks.admin.AdminBookingConfirm;
import tasks.admin.AdminNavbarNavigate;
import tests.CommonTest;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminSalesReportTest extends CommonTest {

    @Test
    @Tag("Admin_Test45")
    @Title("Test45: The system displays a revenue chart by month.")
    public void test45() {
        givenThat(admin).attemptsTo(
                Login.toAdminPage(),
                AdminNavbarNavigate.toBookingConfirmation()
                        .then(AdminBookingConfirm.bookingConfirm())
        );
        //1.Click on the "Sales Report" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toSalesReport());
        //2. Click on the "Revenue of month" tab.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.BTN_TAB_OF_MONTH)
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TABLE_REVENUE.of("Revenue of month")).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test46")
    @Title("Test46: The system displays a revenue chart by selected month.")
    public void test46() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage()
        );
        //1.Click on the "Sales Report" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toSalesReport());
        //2. Click on the "Revenue of month" tab.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.BTN_TAB_OF_MONTH),
                TakeScreenshot.ofElement(AdminPage.TABLE_REVENUE.of("Revenue of month"), "imageOfMonthBefore")
        );
        //3. Choose month.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.BTN_CHOOSE_TIME.of("month")),
                Click.on(AdminPage.LTB_CHOOSE_TIME.of("Apr")),
                TakeScreenshot.ofElement(AdminPage.TABLE_REVENUE.of("Revenue of month"), "imageOfMonthAfter")
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(CompareImage.imgProfilePartner("imageOfMonthBefore", "imageOfMonthAfter")).isFalse()
        );
    }

    @Test
    @Tag("Admin_Test47")
    @Title("Test47: The system displays a revenue chart by year.")
    public void test47() {
        givenThat(admin).attemptsTo(
                Login.toAdminPage(),
                AdminNavbarNavigate.toBookingConfirmation()
                        .then(AdminBookingConfirm.bookingConfirm())
        );
        //1.Click on the "Sales Report" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toSalesReport());
        //2. Click on the "Revenue of year" tab.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.BTN_TAB_OF_YEAR)
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TABLE_REVENUE.of("Revenue of year")).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test48")
    @Title("Test48: The system displays a revenue chart by selected year.")
    public void test48() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(
                Login.toAdminPage()
        );
        //1.Click on the "Sales Report" button on the left navigation bar of the screen.
        when(admin).attemptsTo(
                AdminNavbarNavigate.toSalesReport()
        );
        //2. Click on the "Revenue of month" tab.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.BTN_TAB_OF_YEAR),
                TakeScreenshot.ofElement(AdminPage.TABLE_REVENUE.of("Revenue of year"), "imageOfYearBefore")
        );
        //3. Choose year.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.BTN_CHOOSE_TIME.of("year")),
                Click.on(AdminPage.LTB_CHOOSE_TIME.of("2023")),
                TakeScreenshot.ofElement(AdminPage.TABLE_REVENUE.of("Revenue of year"), "imageOfYearAfter")
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(CompareImage.imgProfilePartner("imageOfYearBefore", "imageOfYearAfter")).isFalse()
        );
    }
}
