package tests.partner;

import helpers.RobotHelper;
import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Attribute;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerRouteManagement;
import tests.CommonTest;
import ui.PartnerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@ExtendWith(SerenityJUnit5Extension.class)
public class PartnerRouteManagementTest extends CommonTest {
    @Test
    @Tag("Partner_Test112")
    @Title("Partner_Test112: Navigates to the “Add New Route” page")
    public void partner_test112() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Route page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement()
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TITLE_ADD_NEW_ROUTE).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test113")
    @Title("Test113: The system displays the message 'Name is required.'")
    public void test113() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Name")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test114")
    @Title("Test114: The system displays the message 'Name is required.'")
    public void test114() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputNameRoute(DataTest.spaceCharacter),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Name")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test115")
    @Title("Test115: The system displays the message 'Name is invalid'")
    public void test115() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Enter a "Name" field with a length greater than 50 characters. On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputNameRoute(DataTest.over50char),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Name")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test116")
    @Title("Test116: The system displays the message 'Price is required.'")
    public void test116() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Price")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test117")
    @Title("Test117: The system displays the message 'Price is required.'")
    public void test117() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(PartnerRouteManagement.inputPrice(DataTest.differentAlphanumeric));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(Attribute.of(PartnerPage.TXT_PRICE).named("aria-valuenow")).isEqualTo("")
        );
    }

    @Test
    @Tag("Partner_Test118")
    @Title("Test118: The system displays the message 'Depart is invalid'")
    public void test118() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Depart")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test119")
    @Title("Test119: The system displays the message 'Depart is invalid'")
    public void test119() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Enter only space characters in the "Depart at" field.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), DataTest.spaceCharacter),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Depart")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test120")
    @Title("Test120: The system displays the message 'Depart is invalid'")
    public void test120() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Enter the "Depart at" field in the correct format: hh:mm. On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "12h20"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Depart")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test121")
    @Title("Test118: The system displays the message 'Arrive is invalid'")
    public void test121() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Arrive")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test122")
    @Title("Test122: The system displays the message 'Arrive is invalid'")
    public void test122() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Enter only space characters in the "Depart at" field.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), DataTest.spaceCharacter),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Arrive")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test123")
    @Title("Test123: The system displays the message 'Arrive is invalid'")
    public void test123() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Enter the "Arrive at" field in the correct format: hh:mm. On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "12h20"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Arrive")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test124")
    @Title("Test124: The system displays the message 'Days is required.'")
    public void test124() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Days")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test125")
    @Title("Test125: The system displays the message 'Days is required.'")
    public void test125() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(PartnerRouteManagement.inputDays(DataTest.differentAlphanumeric));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TXT_DAYS).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test126")
    @Title("Test126: The system displays the message 'From at is required.'")
    public void test126() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("From")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test127")
    @Title("Test127: The system displays the message 'To at is required.'")
    public void test127() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("To")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test128")
    @Title("Test128: The system displays the message 'Transport is required.'")
    public void test128() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Transport")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test129")
    @Title("Test129: The system displays the message 'Route is required.'")
    public void test129() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_SAVE));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Route")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test130")
    @Title("Test130: The system displays the fields 'Pickup point's address' and 'Pickup point's time.'")
    public void test130() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Click on the "Pickup points" button
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_ADD_NEW_PICKUP_POINT));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TXT_PICKUP_POINT_ADDRESS).isDisplayed(),
                Ensure.that(PartnerPage.TXT_PICKUP_POINT_TIME).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test131")
    @Title("Test131: The system not display the fields 'Pickup point's address' and 'Pickup point's time.'")
    public void test131() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Click on the "Pickup points" button
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_PICKUP_POINT)
                        .then(Click.on(PartnerPage.BTN_DELETE_PICKUP_POINT))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TXT_PICKUP_POINT_ADDRESS).isNotDisplayed(),
                Ensure.that(PartnerPage.TXT_PICKUP_POINT_TIME).isNotDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test132")
    @Title("Test132: The system displays the message 'Pickup point's address is required.'")
    public void test132() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_PICKUP_POINT)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("address")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test133")
    @Title("Test133: The system displays the message 'Pickup point's address is required.'")
    public void test133() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_PICKUP_POINT)
                        .then(Enter.theValue(DataTest.spaceCharacter).into(PartnerPage.TXT_PICKUP_POINT_ADDRESS))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("address")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test134")
    @Title("Test134: The system displays the message 'Pickup point's time is required.'")
    public void test134() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_PICKUP_POINT)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("time")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test135")
    @Title("Test135: The system displays the message 'Pickup point's time is required.'")
    public void test135() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_PICKUP_POINT)
                        .then(Enter.theValue("12h20").into(PartnerPage.TXT_PICKUP_POINT_TIME))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("time")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test136")
    @Title("Test136: The system displayed the fields 'Drop of point's address' and 'Drop of point's time.'")
    public void test136() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Click on the "Pickup points" button
        andThat(client).attemptsTo(Click.on(PartnerPage.BTN_ADD_NEW_DROP_POINT));
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TXT_DROP_POINT_ADDRESS).isDisplayed(),
                Ensure.that(PartnerPage.TXT_DROP_POINT_TIME).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test137")
    @Title("Test137: The system not display the fields 'Drop of point's address' and 'Drop of point's time.'")
    public void test137() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.Click on the "Pickup points" button
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_DROP_POINT)
                        .then(Click.on(PartnerPage.BTN_DELETE_DROP_POINT))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TXT_DROP_POINT_ADDRESS).isNotDisplayed(),
                Ensure.that(PartnerPage.TXT_DROP_POINT_TIME).isNotDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test138")
    @Title("Test138: The system displays the message 'Drop of point's address is required.'")
    public void test138() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_DROP_POINT)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("address")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test139")
    @Title("Test139: The system displays the message 'Drop of point's address is required.'")
    public void test139() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_DROP_POINT)
                        .then(Enter.theValue(DataTest.spaceCharacter).into(PartnerPage.TXT_DROP_POINT_ADDRESS))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("address")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test140")
    @Title("Test140: The system displays the message 'Drop of point's time is required.'")
    public void test140() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_DROP_POINT)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("time")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test141")
    @Title("Test141: The system displays the message 'Drop of point's time is required.'")
    public void test141() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, click the "Save" button.
        andThat(client).attemptsTo(
                Click.on(PartnerPage.BTN_ADD_NEW_DROP_POINT)
                        .then(Enter.theValue("12h20").into(PartnerPage.TXT_DROP_POINT_ADDRESS))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE_PICKUP_AND_DROP_POINT.of("time")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test142")
    @Title("Test142: The Route is successfully created. The system displays the message 'Route is created successfully.")
    public void test142() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.createRouteSuccess(
                        "Quang Nam - Da Nang (2)",
                        "50",
                        "07:00",
                        "09:00",
                        "1",
                        "Quang Nam Station",
                        "Da Nang Station",
                        "30",
                        "Car 1"
                )
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is created successfully")
        );
    }

    @Test
    @Tag("Partner_Test145")
    @Title("Test145: The system displays the message 'Name is required.'")
    public void test145() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_NAME)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Name")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test146")
    @Title("Test146: The system displays the message 'Name is required.'")
    public void test146() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_NAME)
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputNameRoute(DataTest.spaceCharacter)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Name")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test147")
    @Title("Test147: The system displays the message 'Name is required.'")
    public void test147() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_NAME)
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputNameRoute("Quang Nam - Da Nang (2)")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test148")
    @Title("Test148: The system displays the message 'Price is required.'")
    public void test148() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_PRICE)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Price")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test149")
    @Title("Test149: The system displays the message 'Route is updated successfully'")
    public void test149() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_PRICE)
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputPrice("100")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test150")
    @Title("Test150: The system displays the message 'Depart at is required'")
    public void test150() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_TIME.of("depart-at"))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Depart")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test151")
    @Title("Test151: The system displays the message 'Route is updated successfully'")
    public void test151() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_TIME.of("depart-at"))
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), "08:00")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test152")
    @Title("Test152: The system displays the message 'Depart at is required'")
    public void test152() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_TIME.of("arrive-at"))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Arrive")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test153")
    @Title("Test153: The system displays the message 'Route is updated successfully'")
    public void test153() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_TIME.of("arrive-at"))
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), "10:00")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test154")
    @Title("Test154: The system displays the message 'Day at is required'")
    public void test154() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_DAYS)
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Day")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test155")
    @Title("Test155: The system displays the message 'Route is updated successfully'")
    public void test155() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                RobotHelper.clearField(PartnerPage.TXT_DAYS)
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.inputDays("2")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test156")
    @Title("Test156: The system displays the message 'From at is required'")
    public void test156() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                Click.on(PartnerPage.BTN_X.of("From"))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("From")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test157")
    @Title("Test157: The system displays the message 'Route is updated successfully'")
    public void test157() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                Click.on(PartnerPage.BTN_X.of("From"))
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, "Quang Nam Bus Station")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test158")
    @Title("Test158: The system displays the message 'Transport at is required'")
    public void test158() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                Click.on(PartnerPage.BTN_X.of("To"))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("To")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test159")
    @Title("Test159: The system displays the message 'Route is updated successfully'")
    public void test159() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                Click.on(PartnerPage.BTN_X.of("To"))
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, "Da Nang Station")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test160")
    @Title("Test160: The system displays the message 'Transport is required'")
    public void test160() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                Click.on(PartnerPage.BTN_X.of("Transport"))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("Transport")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test161")
    @Title("Test161: The system displays the message 'Route is updated successfully'")
    public void test161() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                Click.on(PartnerPage.BTN_X.of("Transport"))
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, "Car 1")
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test162")
    @Title("Test162: The system displays the message 'Route schedules is required'")
    public void test162() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30")
                        .then(Click.on(PartnerPage.TXT_NAME))
                        .then(Click.on(PartnerPage.BTN_SAVE))
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_MESSAGE.of("schedules")).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test163")
    @Title("Test163: The system displays the message 'Route is updated successfully'")
    public void test163() {
        //The system logged in successfully.
        givenThat(client).attemptsTo(Login.toPartnerPage());
        //1.Navigate to Route Management
        when(client).attemptsTo(PartnerNavbarNavigate.toRouteManagement());
        //2.On the "Add New Route" page, enter valid information into all fields. Click button save
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseRouteInList("Quang Nam - Da Nang (2)"),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30")
        );
        //3.Enter only space characters in the "Name" field.
        andThat(client).attemptsTo(
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, "30")
                        .then(Click.on(PartnerPage.TXT_NAME))
                        .then(Click.on(PartnerPage.BTN_SAVE)),
                WaitUntil.the(PartnerPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(PartnerPage.TOAST_MESSAGE).hasText("Route is updated successfully")
        );
    }
}
