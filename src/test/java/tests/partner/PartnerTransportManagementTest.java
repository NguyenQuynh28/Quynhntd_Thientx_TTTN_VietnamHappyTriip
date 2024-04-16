package tests.partner;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Actions;
import tasks.Login;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerTransportManagement;
import tests.CommonTest;
import ui.PartnerPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PartnerTransportManagementTest")
public class PartnerTransportManagementTest extends CommonTest {
    @Test
    @Tag("Partner_Test29")
    @Title("Partner_Test29: Navigates to the “Add New Transport” page")
    public void partner_test29() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement()
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TITLE_ADD_NEW_TRANSPORT).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test30")
    @Title("Partner_Test30: Error [Name is required] is displayed")
    public void partner_test30() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and do not fill in the "Name" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test31")
    @Title("Partner_Test31: Error [Name is required] is displayed")
    public void partner_test31() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport and the "Name" field is filled with space characters
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerTransportManagement.inputNameTransport(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test32")
    @Title("Partner_Test32: Error [Name is invalid] is displayed")
    public void partner_test32() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport and the "Name" field is >50 characters long
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerTransportManagement.inputNameTransport(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Partner_Test33")
    @Title("Partner_Test33: Error [Vehicle type is required*] is displayed")
    public void partner_test33() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and do not choose the "Vehicle type"
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Vehicle type"))).isEqualTo("Vehicle type is required*")
        );
    }

    @Test
    @Tag("Partner_Test34")
    @Title("Partner_Test34: Creating a new transport failed")
    public void partner_test34() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and do not add the "Seat Type"
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerTransportManagement.inputNameTransport("Bus 33"),
                PartnerTransportManagement.chooseVehicleType("Bus"),
                PartnerTransportManagement.importImage("bus1", ".jpg"),
                Click.on(PartnerPage.CHK_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.CHK_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.CHK_UTILITY.of("WiFi")),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.LBL_TRANSPORT.of("Bus 33")).isNotDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test35")
    @Title("Partner_Test35: Error [Please choose the correct image format] is displayed")
    public void partner_test35() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and import the incorrect image format
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerTransportManagement.inputNameTransport("Bus 44"),
                PartnerTransportManagement.chooseVehicleType("Bus"),
                PartnerTransportManagement.addSeatType("Normal Seat", "Normal Seat", "5",
                        "VIP Seat", "VIP Seat", "10",
                        "5", "5"),
                PartnerTransportManagement.importImage("bus1", ".tiff"),
                Click.on(PartnerPage.CHK_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.CHK_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.CHK_UTILITY.of("WiFi")),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                WaitABit.inSecond(3),
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Image"))).isEqualTo("Please choose the correct image format")
        );
    }

    @Test
    @Tag("Partner_Test36")
    @Title("Partner_Test36: Creating a new transport successfully")
    public void partner_test36() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and do not import image
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerTransportManagement.inputNameTransport("Bus 55"),
                PartnerTransportManagement.chooseVehicleType("Bus"),
                PartnerTransportManagement.addSeatType("Normal Seat", "Normal Seat", "5",
                        "VIP Seat", "VIP Seat", "10",
                        "5", "5"),
                Click.on(PartnerPage.CHK_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.CHK_UTILITY.of("Rest Stop")),
                Click.on(PartnerPage.CHK_UTILITY.of("WiFi")),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                WaitUntil.the(PartnerPage.MESSAGE_SUCCESSFULLY, isVisible()),
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Transport is created successfully")
        );
        and(client).attemptsTo(
                WaitUntil.the(PartnerPage.LBL_TRANSPORT.of("Bus 55"), isVisible()),
                Ensure.that(PartnerPage.LBL_TRANSPORT.of("Bus 55")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test37")
    @Title("Partner_Test37: Error [Utility is required] is displayed")
    public void partner_test37() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and do not choose the "Utility"
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Utility"))).isEqualTo("Utility is required")
        );
    }

    @Test
    @Tag("Partner_Test38")
    @Title("Partner_Test38: Choose 1 Utility and creating a new transport successfully")
    public void partner_test38() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Transport page and choose 1 Utility
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                PartnerTransportManagement.inputNameTransport("Bus 99"),
                PartnerTransportManagement.chooseVehicleType("Bus"),
                PartnerTransportManagement.addSeatType("Normal Seat", "Normal Seat", "5",
                        "VIP Seat", "VIP Seat", "10",
                        "5", "5"),
                PartnerTransportManagement.importImage("bus1", ".jpg"),
                Click.on(PartnerPage.CHK_UTILITY.of("Air Conditioner")),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                WaitUntil.the(PartnerPage.MESSAGE_SUCCESSFULLY, isVisible()),
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Transport is created successfully")
        );
    }

    @Test
    @Tag("Partner_Test40")
    @Title("Partner_Test40: The title [Transport Details] is displayed")
    public void partner_test40() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Transport Details page and click any transport in the listbox
        when(client).attemptsTo(
        PartnerNavbarNavigate.toTransportManagement(),
        Click.on(PartnerPage.LBL_TRANSPORT.of("Bus 7"))
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TITLE_TRANSPORT_DETAILS).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test41")
    @Title("Partner_Test41: Error [Name is required] is displayed")
    public void partner_test41() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Transport Details page, click any transport in the listbox and clear the "Name" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Click.on(PartnerPage.LBL_TRANSPORT.of("Bus 7")),
                Clear.field(PartnerPage.TXT_NAME),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test42")
    @Title("Partner_Test42: Error [Name is required] is displayed")
    public void partner_test42() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Transport Details page, click any transport in the listbox and the "Name" field is filled with space characters
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Click.on(PartnerPage.LBL_TRANSPORT.of("Bus 7")),
                PartnerTransportManagement.inputNameTransport(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test43")
    @Title("Partner_Test43: Error [Name is invalid] is displayed")
    public void partner_test43() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Transport Details page, click any transport in the listbox and the "Name" field is >50 characters long
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Click.on(PartnerPage.LBL_TRANSPORT.of("Bus 7")),
                PartnerTransportManagement.inputNameTransport(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Partner_Test49")
    @Title("Partner_Test49: Display the transport to search for.")
    public void partner_test49() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Transport Management page and search transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Actions.inputData(PartnerPage.TXT_SEARCH, "Bus 1")
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.LBL_TRANSPORT.of("Bus 1")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test50")
    @Title("Partner_Test50: Message [No bookings found.] is displayed")
    public void partner_test50() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Transport Management page and search transport
        when(client).attemptsTo(
                PartnerNavbarNavigate.toTransportManagement(),
                Actions.inputData(PartnerPage.TXT_SEARCH, "Airplane")
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.MESSAGE_SEARCH_NO_RESULTS).isDisplayed()
        );
    }
}
