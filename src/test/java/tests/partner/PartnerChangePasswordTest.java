package tests.partner;

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
import tasks.partner.PartnerNavbarNavigate;
import tests.CommonTest;
import ui.ChangePasswordPopup;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PartnerChangePasswordTest")
public class PartnerChangePasswordTest extends CommonTest {
    @Test
    @Tag("Partner_Test97")
    @Title("Partner_Test97: Popup [Change Password] is displayed")
    public void partner_test97() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        then(client).attemptsTo(
                Ensure.that(ChangePasswordPopup.POPUP_CHANGE_PASSWORD).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test98")
    @Title("Partner_Test98: Error [Old Password is required] is displayed")
    public void partner_test98() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner(),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("Old Password"))).isEqualTo("Old Password is required")
        );
    }

    @Test
    @Tag("Partner_Test99")
    @Title("Partner_Test99: Message [Wrong password] is displayed")
    public void partner_test99() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "Old Password" field is different from the current password
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("12345678"),
                ChangePasswordActions.inputNewPassword("Partner30@"),
                ChangePasswordActions.inputConfirmPassword("Partner30@"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Wrong password")
        );
    }

    @Test
    @Tag("Partner_Test100")
    @Title("Partner_Test100: Error [New Password is required] is displayed")
    public void partner_test100() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner(),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is required")
        );
    }

    @Test
    @Tag("Partner_Test101")
    @Title("Partner_Test101: Error [New Password is required] is displayed")
    public void partner_test101() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field is filled with space characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword(DataTest.spaceCharacter),
                ChangePasswordActions.inputConfirmPassword(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is required")
        );
    }

    @Test
    @Tag("Partner_Test102")
    @Title("Partner_Test102: Error [New Password is invalid] is displayed")
    public void partner_test102() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field is filled <8 characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("P1@"),
                ChangePasswordActions.inputConfirmPassword("P1@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test103")
    @Title("Partner_Test103: Error [New Password is invalid] is displayed")
    public void partner_test103() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field contains only numbers
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("12345678"),
                ChangePasswordActions.inputConfirmPassword("12345678")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test104")
    @Title("Partner_Test104: Error [New Password is invalid] is displayed")
    public void partner_test104() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field has only lowercase letters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("aaaaaaaa"),
                ChangePasswordActions.inputConfirmPassword("aaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test105")
    @Title("Partner_Test105: Error [New Password is invalid] is displayed")
    public void partner_test105() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field has only uppercase letters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("AAAAAAAA"),
                ChangePasswordActions.inputConfirmPassword("AAAAAAAA")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test106")
    @Title("Partner_Test106: Error [New Password is invalid] is displayed")
    public void partner_test106() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field contains only special characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("@@@@@@@@"),
                ChangePasswordActions.inputConfirmPassword("@@@@@@@@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test107")
    @Title("Partner_Test107: Error [New Password is invalid] is displayed")
    public void partner_test107() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field does not include 4 types of characters: lowercase, letters, uppercase letters, numbers and special characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("partner"),
                ChangePasswordActions.inputConfirmPassword("partner")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("New Password"))).isEqualTo("New Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test108")
    @Title("Partner_Test108: Message [Duplicate entry] is displayed")
    public void partner_test108() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field does not include 4 types of characters: lowercase, letters, uppercase letters, numbers and special characters
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("partner1"),
                ChangePasswordActions.inputConfirmPassword("partner1"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Duplicate entry")
        );
    }

    @Test
    @Tag("Partner_Test109")
    @Title("Partner_Test109: Error [Confirm Password is required] is displayed")
    public void partner_test109() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner(),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.ERROR_MESSAGE.of("Confirm Password"))).isEqualTo("Confirm Password is required")
        );
    }

    @Test
    @Tag("Partner_Test110")
    @Title("Partner_Test110: Message [Password do not match] is displayed")
    public void partner_test110() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //The "New Password" field and the "Confirm Password" field do not match
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("Partner00@"),
                ChangePasswordActions.inputConfirmPassword("Partner"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Password do not match")
        );
    }

    @Test
    @Tag("Partner_Test111")
    @Title("Partner_Test111: Message [Password updated successfully!] is displayed")
    public void partner_test111() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner Management page and change password
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                ChangePassword.toChangePasswordPartner()
        );
        //Fill in all fields with valid information
        and(client).attemptsTo(
                ChangePasswordActions.inputOldPassword("partner1"),
                ChangePasswordActions.inputNewPassword("Partner1@"),
                ChangePasswordActions.inputConfirmPassword("Partner1@"),
                Click.on(ChangePasswordPopup.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(ChangePasswordPopup.MESSAGE_ALERT)).isEqualTo("Password updated successfully!")
        );
    }
}
