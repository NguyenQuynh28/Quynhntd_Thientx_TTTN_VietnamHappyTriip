package tests.admin;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.CountRoute;
import tasks.Actions;
import tasks.ChangePage;
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
     * Confirm Route
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
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 12"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Quang Nam - Da Nang", 10, "PENDING", "Quang Nam - Da Nang")
                        .then(
                                AdminRouteManagement.chooseRoute("PENDING", "Quang Nam - Da Nang")
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    @Test
    @Tag("Admin_Test92")
    @Title("Admin_Test92: The route success popup is displayed")
    public void admin_test92() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 13"),
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
                PartnerRouteManagement.inputNameRoute("Da Nang - Thang Binh"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 13"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - Thang Binh", 10, "PENDING", "Da Nang - Thang Binh"),
                //Choose info to confirm
                AdminRouteManagement.chooseRoute("PENDING", "Da Nang - Thang Binh")
                        .then(
                                //Choose button Accept
                                AdminRouteManagement.confirmRoute("Accept")
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
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 14"),
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
                PartnerRouteManagement.inputNameRoute("Da Nang - Tam Ky"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 14"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - Tam Ky", 10, "PENDING", "Da Nang - Tam Ky"),
                //Choose info to confirm
                AdminRouteManagement.chooseRoute("PENDING", "Da Nang - Tam Ky"),
                AdminRouteManagement.confirmRoute("Accept")
                        .then(
                                AdminRouteManagement.reconfirmRoute("No")
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
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 15"),
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
                PartnerRouteManagement.inputNameRoute("Da Nang - Binh Yen"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 15"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - Binh Yen", 10, "PENDING", "Da Nang - Binh Yen"),
                //Choose info to confirm
                AdminRouteManagement.chooseRoute("PENDING", "Da Nang - Binh Yen"),
                AdminRouteManagement.confirmRoute("Accept")
                        .then(
                                AdminRouteManagement.reconfirmRoute("Yes")
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
                PartnerVehicleManagement.inputNameTransport("Bus 16"),
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
                PartnerRouteManagement.inputNameRoute("Da Nang - Dien Ban"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 16"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "5"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - Dien Ban", 10, "PENDING", "Da Nang - Dien Ban"),
                AdminRouteManagement.chooseRoute("PENDING", "Da Nang - Dien Ban")
                        .then(
                                AdminRouteManagement.confirmRoute("Deny")
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_CONFIRM_INFORMATION)).isEqualTo("Are you sure that you want to deny this route?")
        );
    }

    @Test
    @Tag("Admin_Test96")
    @Title("Admin_Test96: The Pending route details page displays after pressing the no button")
    public void admin_test96() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 17"),
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
                PartnerRouteManagement.inputNameRoute("Da Nang - Dien Ngoc"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 17"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "5"),
                Click.on(PartnerPage.BTN_SAVE)
        );

        clientBrowser.close();

        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - Dien Ngoc", 10, "PENDING", "Da Nang - Dien Ngoc"),
                AdminRouteManagement.chooseRoute("PENDING", "Da Nang - Dien Ngoc"),
                AdminRouteManagement.confirmRoute("Deny")
                        .then(
                                AdminRouteManagement.reconfirmRoute("No")
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    @Test
    @Tag("Admin_Test97")
    @Title("Admin_Test97: The deny route is successful")
    public void admin_test97() {
        //Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        // Create Transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerVehicleManagement.inputNameTransport("Bus 18"),
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
                PartnerRouteManagement.inputNameRoute("Da Nang - Vinh Dien"),
                PartnerRouteManagement.inputPrice("50"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "17:30"),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "17:30"),
                PartnerRouteManagement.inputDays("1"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Station"),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Hoi An Station"),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Bus 18"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "5"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - Vinh Dien", 10, "PENDING", "Da Nang - Vinh Dien"),
                AdminRouteManagement.chooseRoute("PENDING", "Da Nang - Vinh Dien"),
                AdminRouteManagement.confirmRoute("Deny")
                        .then(
                                AdminRouteManagement.reconfirmRoute("Yes")
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("This route is denied successfully!")
        );
    }


    /**
     * View Route
     */
    @Test
    @Tag("Admin_Test98")
    @Title("Admin_Test98: The system displays accepted information")
    public void admin_test98() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                ChangePage.change("Da Nang - TanSonNhat", 10, "ACCEPTED", "Da Nang - TanSonNhat")
                        .then(
                                AdminRouteManagement.chooseRoute("ACCEPTED", "Da Nang - TanSonNhat")
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    @Test
    @Tag("Admin_Test99")
    @Title("Admin_Test99:The system displays denied information")
    public void admin_test99() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement(),
                //Choose button accept
                ChangePage.change("Quang Nam - Da Nang", 10, "DENIED", "Quang Nam - Da Nang")
                        .then(
                                AdminRouteManagement.chooseRoute("DENIED", "Quang Nam - Da Nang")
                        )
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.TXT_ROUTE_DETAILS)).isEqualTo("Pending route details")
        );
    }

    /**
     * Search Route
     */
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

    @Test
    @Tag("Admin_Test102")
    @Title("Admin_Test102: All route information is displayed")
    public void admin_test102() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Route Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toRouteManagement()
        );
        then(admin).should(
                seeThat("All routes are displayed after clicking the clear button", CountRoute.countRoute("AZrowuuM", "Showing 16 to 19"))
        );
    }
}
