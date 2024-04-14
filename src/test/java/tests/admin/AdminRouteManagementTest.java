package tests.admin;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Actions;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import tasks.admin.AdminRouteManagement;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerRouteManagement;
import tasks.partner.PartnerVehicleManagement;
import tests.CommonTest;
import ui.AdminPage;
import ui.PartnerPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminRouteManagementTest extends CommonTest {
    /**
     *
     *
     */
    @Test
    @Tag("Admin_Test91")
    @Title("Admin_Test91: The popup to choose whether to accept or decline is displayed")
    public void admin_test91() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 2"),
                PartnerVehicleManagement.chooseVehicleType("Bus"),
                PartnerVehicleManagement.addSeatType("Normal Seat", "Seating at the bottom", "5",
                        "VIP Seat", "The seats are at the bottom and near the window", "10", "5", "5"),
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, ".jpg", "BusStopIMG"),
                Click.on(PartnerPage.BTN_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.BTN_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.BTN_UTILITY.of("WiFi")),
                WaitABit.inSecond(2),
                Click.on(PartnerPage.BTN_SAVE)
        );
        // Create Route
        when(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                PartnerRouteManagement.inputNameRoute("Quang Nam - Da Nang"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 2"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "5"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                Click.on(AdminPage.BTN_PAGES.of("2")),
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Quang Nam"))
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    @Test
    @Tag("Admin_Test92")
    @Title("Admin_Test92: The route success popup is displayed")
    public void admin_test92() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("2")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Quang Nam"))
                        .then(
                                //Choose button Accept
                                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Accept"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_CONFIRM_INFORMATION)).isEqualTo("Are you sure that you want to accept this route?")
        );
    }

    @Test
    @Tag("Admin_Test93")
    @Title("Admin_Test93: The Pending route details page displays after pressing the no button")
    public void admin_test93() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("2")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Quang Nam - Da Nang")),
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Accept"))
                        .then(
                                Click.on(AdminPage.BTN_RECONFIRM.of("No"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    @Test
    @Tag("Admin_Test94")
    @Title("Admin_Test94: Confirmation route is success ")
    public void admin_test94() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("2")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Quang Nam - Da Nang")),
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Accept"))
                        .then(
                                Click.on(AdminPage.BTN_RECONFIRM.of("Yes"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("This route is accepted successfully!")
        );
    }

    @Test
    @Tag("Admin_Test95")
    @Title("Admin_Test95: The route deny popup is displayed")
    public void admin_test95() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 10"),
                PartnerVehicleManagement.chooseVehicleType("Bus"),
                PartnerVehicleManagement.addSeatType("Normal Seat", "Seating at the bottom", "5",
                        "VIP Seat", "The seats are at the bottom and near the window", "10", "5", "5"),
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, ".jpg", "BusStopIMG"),
                Click.on(PartnerPage.BTN_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.BTN_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.BTN_UTILITY.of("WiFi")),
                WaitABit.inSecond(2),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Create Route
        and(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                PartnerRouteManagement.inputNameRoute("Da Nang - Hoi An"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 1"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "5"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                Click.on(AdminPage.BTN_PAGES.of("4")),
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Hoi An"))
                        .then(
                                //Choose button Deny
                                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Deny"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_CONFIRM_INFORMATION)).isEqualTo("Are you sure that you want to deny this route?")
        );
    }

    /**
     *
     *
     */
    @Test
    @Tag("Admin_Test96")
    @Title("Admin_Test96: The Pending route details page displays after pressing the no button")
    public void admin_test96() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("4")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Hoi An")),
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Deny"))
                        .then(
                                Click.on(AdminPage.BTN_RECONFIRM.of("No"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    /**
     *
     *
     */
    @Test
    @Tag("Admin_Test97")
    @Title("Admin_Test97: The deny route is successful")
    public void admin_test97() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("4")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Hoi An")),
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Deny"))
                        .then(
                                Click.on(AdminPage.BTN_RECONFIRM.of("Yes"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("This route is denied successfully!")
        );
    }

    /**
     *
     *
     */
    @Test
    @Tag("Admin_Test98")
    @Title("Admin_Test98: The system displays accepted information")
    public void admin_test98() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 11"),
                PartnerVehicleManagement.chooseVehicleType("Bus"),
                PartnerVehicleManagement.addSeatType("Normal Seat", "Seating at the bottom", "5",
                        "VIP Seat", "The seats are at the bottom and near the window", "10", "5", "5"),
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, ".jpg", "BusStopIMG"),
                Click.on(PartnerPage.BTN_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.BTN_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.BTN_UTILITY.of("WiFi")),
                WaitABit.inSecond(2),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Create Route
        and(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                PartnerRouteManagement.inputNameRoute("Da Nang - Quang Tri"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("3"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 11"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "7"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("1")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Quang Tri")),
                //Choose button accept
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Accept")),
                //Choose yes to confirm information
                Click.on(AdminPage.BTN_RECONFIRM.of("Yes"))
                        .then(
                                Click.on(AdminPage.LBL_ACCEPT.of("Da Nang - Quang Tri"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    /**
     *
     *
     */

    @Test
    @Tag("Admin_Test99")
    @Title("Admin_Test99:The system displays denied information")
    public void admin_test99() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 12"),
                PartnerVehicleManagement.chooseVehicleType("Bus"),
                PartnerVehicleManagement.addSeatType("Normal Seat", "Seating at the bottom", "5",
                        "VIP Seat", "The seats are at the bottom and near the window", "10", "5", "5"),
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, ".jpg", "BusStopIMG"),
                Click.on(PartnerPage.BTN_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.BTN_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.BTN_UTILITY.of("WiFi")),
                WaitABit.inSecond(2),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Create Route
        and(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                PartnerRouteManagement.inputNameRoute("Da Nang - Quang Binh"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("3"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 12"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "7"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose page
                Click.on(AdminPage.BTN_PAGES.of("4")),
                //Choose info to confirm
                Click.on(AdminPage.LBL_WAITING_CONFIRM_ROUTE.of("Da Nang - Quang Binh")),
                //Choose button accept
                Click.on(AdminPage.BTN_CONFIRM_ROUTE.of("Deny")),
                //Choose yes to confirm information
                Click.on(AdminPage.BTN_RECONFIRM.of("Yes"))
                        .then(
                                Click.on(AdminPage.LBL_DENY.of("Da Nang - Quang Binh"))
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    @Test
    @Tag("Admin_Test100")
    @Title("Admin_Test100: Notice no bookings found is displayed")
    public void admin_test100() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                AdminRouteManagement.searchRoute("Ho Chi Minh")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SEARCH_ROUTE)).isEqualTo("No routes found.")
        );
    }

    @Test
    @Tag("Admin_Test101")
    @Title("Admin_Test101: Search information is displayed")
    public void admin_test101() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                AdminRouteManagement.searchRoute("Hà Nội - Đà Nẵng")
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LBL_ROUTE_NAME.of("Hà Nội - Đà Nẵng")).isDisplayed()
        );
    }

    /**
     *
     *
     */
    @Test
    @Tag("Admin_Test102")
    @Title("Admin_Test102: All route information is displayed")
    public void admin_test102() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                AdminRouteManagement.searchRoute("Hà Nội - Đà Nẵng"),
                WaitABit.inSecond(2)
                        .then(
                                Ensure.that(Text.of(AdminPage.TXT_NUMBER_OF_PAGES)).isEqualTo("Showing 1 to 1 of 1 entries")
                        ),
                Click.on(AdminPage.BTN_CLEAR)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_NUMBER_OF_PAGES)).isEqualTo("Showing 1 to 5 of 19 entries")
        );
    }
}
