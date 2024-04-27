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
import tasks.Signup;
import tasks.SignupInfo;
import tests.CommonTest;
import ui.SignupPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PartnerSignupTest")
public class PartnerSignupTest extends CommonTest {
    @Test
    @Tag("Partner_Test01")
    @Title("Partner_Test01: Navigates to the [PARTNER SIGN UP] page")
    public void partner_test01() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        then(client).attemptsTo(
                Ensure.that(SignupPage.TITLE_PARTNER_SIGN_UP).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test02")
    @Title("Partner_Test02: Error [Name is required] is displayed")
    public void partner_test02() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Do not fill in the "Name" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test03")
    @Title("Partner_Test03: Error [Name is required] is displayed")
    public void partner_test03() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Name" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputName(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test04")
    @Title("Partner_Test04: Error [Name is invalid] is displayed")
    public void partner_test04() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Name" field is >50 characters long
        when(client).attemptsTo(
                SignupInfo.inputName(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Partner_Test05")
    @Title("Partner_Test05: Error [Email is required] is displayed")
    public void partner_test05() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Do not fill in the "Email" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is required")
        );
    }

    @Test
    @Tag("Partner_Test06")
    @Title("Partner_Test06: Error [Email is invalid] is displayed")
    public void partner_test06() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Email" field is filled including a space character
        when(client).attemptsTo(
                SignupInfo.inputEmail("partner7   @gmail.com")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is invalid")
        );
    }

    @Test
    @Tag("Partner_Test07")
    @Title("Partner_Test07: Error [Email is invalid] is displayed")
    public void partner_test07() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Email" field does not include the extension "@gmail.com"
        when(client).attemptsTo(
                SignupInfo.inputEmail("partner7")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is invalid")
        );
    }

    @Test
    @Tag("Partner_Test08")
    @Title("Partner_Test08: Error [Email is invalid] is displayed")
    public void partner_test08() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Email" field is filled only "@gmail.com"
        when(client).attemptsTo(
                SignupInfo.inputEmail("@gmail.com")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is invalid")
        );
    }

    @Test
    @Tag("Partner_Test09")
    @Title("Partner_Test09: Error [Phone number is required] is displayed")
    public void partner_test09() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Do not fill in the "Phone number" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Partner_Test10")
    @Title("Partner_Test10: Error [Phone number is required] is displayed")
    public void partner_test10() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Phone number" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Partner_Test11")
    @Title("Partner_Test11: Error [Phone number is invalid] is displayed")
    public void partner_test11() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Phone number" field is filled a phone number <7 numeric characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("123456")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Partner_Test12")
    @Title("Partner_Test12: Error [Phone number is invalid] is displayed")
    public void partner_test12() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Phone number" field is filled a phone number >12 numeric characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("12345678910111213")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Partner_Test13")
    @Title("Partner_Test13: Error [Phone number is invalid] is displayed")
    public void partner_test13() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Phone number" field contains non-numeric characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("abc@@@@@@@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Partner_Test14")
    @Title("Partner_Test14: Error [Username is required] is displayed")
    public void partner_test14() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Do not fill in the "Username" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Partner_Test15")
    @Title("Partner_Test15: Error [Username is required] is displayed")
    public void partner_test15() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Username" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputUserName(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Partner_Test16")
    @Title("Partner_Test16: Error [Username is invalid] is displayed")
    public void partner_test16() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Username" field is >50 characters long
        when(client).attemptsTo(
                SignupInfo.inputUserName(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is invalid")
        );
    }

    @Test
    @Tag("Partner_Test17")
    @Title("Partner_Test17: Message [Duplicate entry] is displayed")
    public void partner_test17() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Username" field matches an existing username
        when(client).attemptsTo(
                SignupInfo.inputName("partner7"),
                SignupInfo.inputEmail("partner7@gmail.com"),
                SignupInfo.inputPhoneNumber("123456789"),
                SignupInfo.inputUserName("partner1"),
                SignupInfo.inputPassword("Partner7@"),
                SignupInfo.inputConfirmPassword("Partner7@"),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.MESSAGE_DUPLICATE_ENTRY)).contains("Duplicate entry")
        );
    }

    @Test
    @Tag("Partner_Test18")
    @Title("Partner_Test18: Error [Password is required] is displayed")
    public void partner_test18() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Do not fill in the "Password" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Partner_Test19")
    @Title("Partner_Test19: Error [Password is required] is displayed")
    public void partner_test19() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputPassword(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Partner_Test20")
    @Title("Partner_Test20: Error [Password is invalid] is displayed")
    public void partner_test20() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field is filled <8 characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("Pa8@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test21")
    @Title("Partner_Test21: Error [Password is invalid] is displayed")
    public void partner_test21() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field contains only numbers
        when(client).attemptsTo(
                SignupInfo.inputPassword("123456789")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test22")
    @Title("Partner_Test22: Error [Password is invalid] is displayed")
    public void partner_test22() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field has only lowercase letters
        when(client).attemptsTo(
                SignupInfo.inputPassword("aaaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test23")
    @Title("Partner_Test23: Error [Password is invalid] is displayed")
    public void partner_test23() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field has only uppercase letters
        when(client).attemptsTo(
                SignupInfo.inputPassword("AAAAAAAAA")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test24")
    @Title("Partner_Test24: Error [Password is invalid] is displayed")
    public void partner_test24() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field contains only special characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("@@@@@@@@@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test25")
    @Title("Partner_TesT25: Error [Password is invalid] is displayed")
    public void partner_test25() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field does not include 4 types of characters: lowercase, letters, uppercase letters, numbers and special characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("partner8")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Partner_Test26")
    @Title("Partner_Test26: Error [Confirm Password is required] is displayed")
    public void partner_test26() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Do not fill in the "Confirm Password" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Confirm Password"))).isEqualTo("Confirm Password is required")
        );
    }

    @Test
    @Tag("Partner_Test27")
    @Title("Partner_Test27: Message [Password and Confirm Password do not match] is displayed")
    public void partner_test27() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //The "Password" field and the "Confirm Password" field do not match
        when(client).attemptsTo(
                SignupInfo.inputName("partner9"),
                SignupInfo.inputEmail("partner9@gmail.com"),
                SignupInfo.inputPhoneNumber("123456789"),
                SignupInfo.inputUserName("partner9"),
                SignupInfo.inputPassword("Partner9@"),
                SignupInfo.inputConfirmPassword("Partner9"),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.MESSAGE_ALERT)).contains("Password and Confirm Password do not match")
        );
    }

    @Test
    @Tag("Partner_Test28")
    @Title("Partner_Test28: Message [Register successfully!] is displayed")
    public void partner_test28() {
        //Accessed successfully the [PARTNER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPartner());

        //Fill in all fields with valid information
        when(client).attemptsTo(
                SignupInfo.inputName("partner1000"),
                SignupInfo.inputEmail("partner1000@gmail.com"),
                SignupInfo.inputPhoneNumber("123456789"),
                SignupInfo.inputUserName("partner1000"),
                SignupInfo.inputPassword("Partner1000@"),
                SignupInfo.inputConfirmPassword("Partner1000@"),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.MESSAGE_ALERT)).contains("Register successfully!")
        );
    }
}