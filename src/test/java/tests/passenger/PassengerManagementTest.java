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
        givenThat(client).attemptsTo(Login.toPassengerPage());
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                PassengerManagement.inputName("               "),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                PassengerManagement.inputEmial("          "),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                PassengerManagement.inputEmial("xuan"),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                PassengerManagement.inputEmial("@gmail.com"),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                PassengerManagement.inputPhoneNumber("           "),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                PassengerManagement.inputName("ThienTX"),
                PassengerManagement.inputEmial("thien@gmail.com"),
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
        givenThat(client).attemptsTo(Login.toPassengerPage());
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                PassengerManagement.clikUpdate(),
                Click.on(PassengerPage.BTN_CANCEL)
        );
        then(client).attemptsTo(
                Ensure.that(Value.of(PassengerPage.TXT_NAME)).contains("ThienTX"),
                Ensure.that(Value.of(PassengerPage.TXT_EMAIL)).contains("thien@gmail.com"),
                Ensure.that(Value.of(PassengerPage.TXT_PHONE_NUMBER)).contains("0475682117")
        );
    }
}
