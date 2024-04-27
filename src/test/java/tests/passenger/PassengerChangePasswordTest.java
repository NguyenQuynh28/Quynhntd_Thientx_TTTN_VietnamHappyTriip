package tests.passenger;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.ChangePassword;
import tasks.ChangePasswordActions;
import tasks.Login;
import tasks.passenger.PassengerNavbarNavigate;
import tests.CommonTest;
import ui.ChangePasswordPopup;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PassengerChangePasswordTest")
public class PassengerChangePasswordTest extends CommonTest {
    @Test
    @Tag("Passenger_Test65")
    @Title("Passenger_Test65: Popup [Change Password] is displayed")
    public void passenger_test65() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        then(client).attemptsTo(
                Ensure.that(ChangePasswordPopup.POPUP_CHANGE_PASSWORD).isDisplayed()
        );
    }

    @Test
    @Tag("Passenger_Test66")
    @Title("Passenger_Test66: Error [Old Password is required] is displayed")
    public void passenger_test66() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger(),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("Old Password"))).isEqualTo("Old Password is required")
        );
    }

    @Test
    @Tag("Passenger_Test67")
    @Title("Passenger_Test67: Message [Wrong password] is displayed")
    public void passenger_test67() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "Old Password" field is different from the current password
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh123"),
                ChangePasswordActions.inputNewPassword("diemquynh123@Diemquynh"),
                ChangePasswordActions.inputConfirmPassword("diemquynh123@Diemquynh"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Wrong password")
        );
    }

    @Test
    @Tag("Passenger_Test68")
    @Title("Passenger_Test68: Error [New Password is required] is displayed")
    public void passenger_test68() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger(),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is required")
        );

    }

    @Test
    @Tag("Passenger_Test69")
    @Title("Passenger_Test69: Error [New Password is required] is displayed")
    public void partner_test69() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field is filled with space characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword(DataTest.spaceCharacter),
                ChangePasswordActions.inputConfirmPassword(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is required")
        );

    }

    @Test
    @Tag("Passenger_Test70")
    @Title("Passenger_Test70: Error [New Password is invalid] is displayed")
    public void passenger_test70() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field is filled <8 characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("P1@"),
                ChangePasswordActions.inputConfirmPassword("P1@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );

    }

    @Test
    @Tag("Passenger_Test71")
    @Title("Passenger_Test71: Error [New Password is invalid] is displayed")
    public void passenger_test71() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field contains only numbers
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("12345678"),
                ChangePasswordActions.inputConfirmPassword("12345678")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );

    }

    @Test
    @Tag("Passenger_Test72")
    @Title("Passenger_Test72: Error [New Password is invalid] is displayed")
    public void passenger_test72() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field has only lowercase letters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("aaaaaaaa"),
                ChangePasswordActions.inputConfirmPassword("aaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );

    }

    @Test
    @Tag("Passenger_Test73")
    @Title("Passenger_Test73: Error [New Password is invalid] is displayed")
    public void passenger_test73() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field has only uppercase letters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("AAAAAAAA"),
                ChangePasswordActions.inputConfirmPassword("AAAAAAAA")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );

    }

    @Test
    @Tag("Passenger_Test74")
    @Title("Passenger_Test74: Error [New Password is invalid] is displayed")
    public void passenger_test74() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field contains only special characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("@@@@@@@@"),
                ChangePasswordActions.inputConfirmPassword("@@@@@@@@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );

    }

    @Test
    @Tag("Passenger_Test75")
    @Title("Passenger_Test75: Error [New Password is invalid] is displayed")
    public void passenger_test75() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field does not include 4 types of characters: lowercase, letters, uppercase letters, numbers and special characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("passenger@"),
                ChangePasswordActions.inputConfirmPassword("passenger@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );

    }

    @Test
    @Tag("Passenger_Test76")
    @Title("Passenger_Test76: Message [Duplicate entry] is displayed")
    public void passenger_test76() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field matches old password
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("diemquynh"),
                ChangePasswordActions.inputConfirmPassword("diemquynh"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Duplicate entry")
        );

    }

    @Test
    @Tag("Passenger_Test77")
    @Title("Passenger_Test77: Error [Confirm Password is required] is displayed")
    public void passenger_test77() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger(),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("Confirm Password"))).isEqualTo("Confirm Password is required")
        );

    }

    @Test
    @Tag("Passenger_Test78")
    @Title("Passenger_Test78: Message [Password do not match] is displayed")
    public void passenger_test78() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //The "New Password" field and the "Confirm Password" field do not match
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("Diemquynh00@"),
                ChangePasswordActions.inputConfirmPassword("Passenger1@"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Password do not match")
        );

    }

    @Test
    @Tag("Passenger_Test79")
    @Title("Passenger_Test79: Message [Password updated successfully!] is displayed")
    public void passenger_test79() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PassengerNavbarNavigate.toPassengerManagement(),
                ChangePassword.toChangePasswordPassenger()
        );
        //Fill in all fields with valid information
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("diemquynh"),
                ChangePasswordActions.inputNewPassword("Diemquynh1@"),
                ChangePasswordActions.inputConfirmPassword("Diemquynh1@"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Password updated successfully!")
        );
    }
}
