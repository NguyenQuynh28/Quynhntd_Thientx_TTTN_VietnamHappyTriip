package tests.passenger;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Value;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.passenger.PassengerManagement;
import tasks.passenger.PassengerNavbarNavigate;
import tests.CommonTest;
import ui.PassengerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
public class PassengerManagementTest extends CommonTest {
    /**
     * Update Passenger
     */
    @Test
    @Tag("Passenger_Test50")
    @Title("Passenger_Test50: The passenger management is displayed")
    public void Passenger_test43() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Navigate to Passenger Management
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement()

        );
        then(client).should(
                seeThat("The Passenger Management is displayed", the(PassengerPage.TITLE_PASSENGER_MANAGEMENT), isVisible())
        );
    }

    @Test
    @Tag("Passenger_Test51")
    @Title("Passenger_Test51: [Name is required] is displayed")
    public void Passenger_test51() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Do not fill in the "Name" field
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.removeText(PassengerPage.TXT_NAME),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Passenger_Test52")
    @Title("Passenger_Test52: [Name is required] is displayed")
    public void Passenger_test52() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // The "Name" field is filled with space
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputName(DataTest.spaceCharacter),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Passenger_Test53")
    @Title("Passenger_Test53: [Name is invalid] is displayed")
    public void Passenger_test53() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //The "Name" field is >50 characters long
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputName(DataTest.over50char),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test54")
    @Title("Passenger_Test54: [Email is required] is displayed")
    public void Passenger_test54() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Do not fill in the "Email" field
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.removeText(PassengerPage.TXT_EMAIL),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is required")
        );
    }

    @Test
    @Tag("Passenger_Test55")
    @Title("Passenger_Test55: [Email must be a valid email] is displayed")
    public void Passenger_test55() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // The "Email" field is filled with space
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputEmail(DataTest.spaceCharacter),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Passenger_Test56")
    @Title("Passenger_Test56: [Email must be a valid email] is displayed")
    public void Passenger_test56() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // The "Email" field does not include the extension "@gmail.com"
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputEmail("xuan"),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Passenger_Test57")
    @Title("Passenger_Test57: [Email must be a valid email] is displayed")
    public void Passenger_test57() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // The "Email" field is filled only "@gmail.com"
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputEmail("@gmail.com"),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Passenger_Test58")
    @Title("Passenger_Test58: [Phone number is required] is displayed")
    public void Passenger_test58() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Do not fill in the "Phone number" field
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.removeText(PassengerPage.TXT_PHONE_NUMBER),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Passenger_Test59")
    @Title("Passenger_Test59: [Phone number is required] is displayed")
    public void Passenger_test59() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //The "Phone number" field is filled with space
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputPhoneNumber(DataTest.spaceCharacter),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Passenger_Test60")
    @Title("Passenger_Test60: [Phone number is invalid] is displayed")
    public void Passenger_test60() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //The "Phone number" field is filled a phone number <7 numeric characters
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputPhoneNumber("012345"),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test61")
    @Title("Passenger_Test61: [Phone number is invalid] is displayed")
    public void Passenger_test61() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //The "Phone number" field is filled a phone number >12 numeric characters
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputPhoneNumber("0123451258746987"),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test62")
    @Title("Passenger_Test62: [Profile updated successfully!] is displayed")
    public void Passenger_test62() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // //Fill in all fields with valid information
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                PassengerManagement.inputName("ThienTX"),
                PassengerManagement.inputEmail("thien@gmail.com"),
                PassengerManagement.inputPhoneNumber("0475682117"),
                PassengerManagement.clickSave()
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PassengerPage.MESSAGE_SUCCESS)).isEqualTo("Profile updated successfully!")
        );
    }

    @Test
    @Tag("Passenger_Test63")
    @Title("Passenger_Test63: All information is displayed")
    public void Passenger_test63() {
        // Logged in successfully to the login page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        // Cancel update information
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clickUpdate(),
                Click.on(PassengerPage.BTN_CANCEL)
        );
        then(client).attemptsTo(
                Ensure.that(Value.of(PassengerPage.TXT_NAME)).contains("ThienTX"),
                Ensure.that(Value.of(PassengerPage.TXT_EMAIL)).contains("thien@gmail.com"),
                Ensure.that(Value.of(PassengerPage.TXT_PHONE_NUMBER)).contains("0475682117")
        );
    }
}
