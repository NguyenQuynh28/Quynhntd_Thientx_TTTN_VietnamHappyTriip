package tests;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Actions;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerRouteManagement;
import tasks.partner.PartnerVehicleManagement;
import ui.AdminPage;
import ui.PartnerPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminTest extends CommonTest {
    @Test
    @Tag("Test01")
    @Title("Test01: The Booking Confirmation is displayed")
    public void test01() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(AdminNavbarNavigate.toBookingConfirmation());

        then(admin).should(
                seeThat("The Booking Confirmation is displayed", the(AdminPage.TITLE_BOOKING_CONFIRMATION), isVisible())
        );
    }

    @Test
    @Tag("Admin_Test02")
    @Title("Admin_Test02: The popup is displayed")
    public void admin_test02() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 2"),
                PartnerVehicleManagement.chooseVehicleType("Bus"),
                PartnerVehicleManagement.addSeatType("Normal Seat", "Seating at the bottom", "5",
                        "VIP Seat", "The seats are at the bottom and near the window", "10", "5", "5"),
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, ".jpg"),
                Click.on(PartnerPage.BTN_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.BTN_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.BTN_UTILITY.of("WiFi")),
                WaitABit.inSecond(2),
                Click.on(PartnerPage.BTN_SAVE)
        );
        // Create Route
        when(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                PartnerRouteManagement.inputNameRoute("Da Nang - Quang Nam"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST,"Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST,"Bus 1"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY,"5"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation()
        );

    }


    @Test
    @Tag("Test13")
    @Title("Test13: The title Add New User is displayed")
    public void test13() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminNavbarNavigate.toAddNewUser()
        );
        then(admin).should(
                seeThat("The title Add New User is displayed", the(AdminPage.TITLE_ADD_NEW_USER), isVisible())
        );
    }

    @Test
    @Tag("Test14")
    @Title("Test14: Error [Name is required] is displayed")
    public void test14() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Name" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminNavbarNavigate.toAddNewUser()
        );
        then(admin).should(
                seeThat("The title Add New User is displayed", the(AdminPage.TITLE_ADD_NEW_USER), isVisible())
        );
    }
}

