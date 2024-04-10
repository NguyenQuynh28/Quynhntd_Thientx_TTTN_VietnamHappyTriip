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
import tasks.Signup;
import tasks.SignupInfo;
import tests.CommonTest;
import ui.SignupPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PassengerSignupTest")
public class PassengerSignupTest extends CommonTest {
    @Test
    @Tag("Passenger_Test01")
    @Title("Passenger_Test01: Navigates to the [PASSENGER SIGN UP] page")
    public void passenger_test01() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        then(client).attemptsTo(
                Ensure.that(SignupPage.TITLE_PASSENGER_SIGN_UP).isDisplayed()
        );
    }

    @Test
    @Tag("Passenger_Test02")
    @Title("Passenger_Test02: Error [Name is required] is displayed")
    public void passenger_test02() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Do not fill in the "Name" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Passenger_Test03")
    @Title("Passenger_Test03: Error [Name is required] is displayed")
    public void passenger_test03() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Name" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputName("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Passenger_Test04")
    @Title("Passenger_Test04: Error [Name is invalid] is displayed")
    public void passenger_test04() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Name" field is >50 characters long
        when(client).attemptsTo(
                SignupInfo.inputName(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test05")
    @Title("Passenger_Test05: Error [Email is required] is displayed")
    public void passenger_test05() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Do not fill in the "Email" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is required")
        );
    }

    @Test
    @Tag("Passenger_Test06")
    @Title("Passenger_Test06: Error [Email is invalid] is displayed")
    public void passenger_test06() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Email" field is filled including a space character
        when(client).attemptsTo(
                SignupInfo.inputEmail("xuan  @gmail.com")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test07")
    @Title("Passenger_Test07: Error [Email is invalid] is displayed")
    public void passenger_test07() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Email" field does not include the extension "@gmail.com"
        when(client).attemptsTo(
                SignupInfo.inputEmail("xuan")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test08")
    @Title("Passenger_Test08: Error [Email is invalid] is displayed")
    public void passenger_test08() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Email" field is filled only "@gmail.com"
        when(client).attemptsTo(
                SignupInfo.inputEmail("@gmail.com")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test09")
    @Title("Passenger_Test09: Error [Phone number is required] is displayed")
    public void passenger_test09() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Do not fill in the "Phone number" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Passenger_Test10")
    @Title("Passenger_Test10: Error [Phone number is required] is displayed")
    public void passenger_test10() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Phone number" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Passenger_Test11")
    @Title("Passenger_Test11: Error [Phone number is invalid] is displayed")
    public void passenger_test11() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Phone number" field is filled a phone number <7 numeric characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("090574")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test12")
    @Title("Passenger_Test12: Error [Phone number is invalid] is displayed")
    public void passenger_test12() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Phone number" field is filled a phone number >12 numeric characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("0905743128536832")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test13")
    @Title("Passenger_Test13: Error [Phone number is invalid] is displayed")
    public void passenger_test13() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Phone number" field contains non-numeric characters
        when(client).attemptsTo(
                SignupInfo.inputPhoneNumber("abc@@@@@@@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test14")
    @Title("Passenger_Test14: Error [Username is required] is displayed")
    public void passenger_test14() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Do not fill in the "Username" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Passenger_Test15")
    @Title("Passenger_Test15: Error [Username is required] is displayed")
    public void passenger_test15() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Username" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputUserName("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Passenger_Test16")
    @Title("Passenger_Test16: Error [Username is invalid] is displayed")
    public void passenger_test16() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Username" field is >50 characters long
        when(client).attemptsTo(
                SignupInfo.inputUserName(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test17")
    @Title("Passenger_Test17: Message [Duplicate entry] is displayed")
    public void passenger_test17() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Username" field matches an existing username
        when(client).attemptsTo(
                SignupInfo.inputName("Xuan17"),
                SignupInfo.inputEmail("xuan17@gmail.com"),
                SignupInfo.inputPhoneNumber("0905743128"),
                SignupInfo.inputUserName("diemquynh"),
                SignupInfo.inputPassword("12345@Xuan"),
                SignupInfo.inputConfirmPassword("12345@Xuan"),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.MESSAGE_DUPLICATE_ENTRY)).contains("Duplicate entry")
        );
    }

    @Test
    @Tag("Passenger_Test18")
    @Title("Passenger_Test18: Error [Password is required] is displayed")
    public void passenger_test18() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Do not fill in the "Password" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Passenger_Test19")
    @Title("Passenger_Test19: Error [Password is required] is displayed")
    public void passenger_test19() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field is filled with space characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Passenger_Test20")
    @Title("Passenger_Test20: Error [Password is invalid] is displayed")
    public void passenger_test20() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field is filled <8 characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("15@Xu")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test21")
    @Title("Passenger_Test21: Error [Password is invalid] is displayed")
    public void passenger_test21() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field contains only numbers
        when(client).attemptsTo(
                SignupInfo.inputPassword("12345678910")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test22")
    @Title("Passenger_Test22: Error [Password is invalid] is displayed")
    public void passenger_test22() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field has only lowercase letters
        when(client).attemptsTo(
                SignupInfo.inputPassword("xuannnnnnnnn")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test23")
    @Title("Passenger_Test23: Error [Password is invalid] is displayed")
    public void passenger_test23() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field has only uppercase letters
        when(client).attemptsTo(
                SignupInfo.inputPassword("XUANHOAXDFF")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test24")
    @Title("Passenger_Test24: Error [Password is invalid] is displayed")
    public void passenger_test24() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field contains only special characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("@!#%$^^^^@@@@@")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test25")
    @Title("Passenger_TesT25: Error [Password is invalid] is displayed")
    public void passenger_test25() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field does not include 4 types of characters: lowercase, letters, uppercase letters, numbers and special characters
        when(client).attemptsTo(
                SignupInfo.inputPassword("12345@XUAN")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Passenger_Test26")
    @Title("Passenger_Test26: Error [Confirm Password is required] is displayed")
    public void passenger_test26() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Do not fill in the "Confirm Password" field
        when(client).attemptsTo(
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.ERROR_MESSAGE.of("Confirm Password"))).isEqualTo("Confirm Password is required")
        );
    }

    @Test
    @Tag("Passenger_Test27")
    @Title("Passenger_Test27: Message [Password and Confirm Password do not match] is displayed")
    public void passenger_test27() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //The "Password" field and the "Confirm Password" filed do not match
        when(client).attemptsTo(
                SignupInfo.inputName("Xuan28"),
                SignupInfo.inputEmail("xuan28@gmail.com"),
                SignupInfo.inputPhoneNumber("0905743128"),
                SignupInfo.inputUserName("xuan1228"),
                SignupInfo.inputPassword("12345@Xuan"),
                SignupInfo.inputConfirmPassword("12345@XUAN"),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.MESSAGE_ALERT)).contains("Password and Confirm Password do not match")
        );
    }

    @Test
    @Tag("Passenger_Test28")
    @Title("Passenger_Test28: Message [Register successfully!] is displayed")
    public void passenger_test28() {
        //Accessed successfully the [PASSENGER SIGN UP] page
        givenThat(client).attemptsTo(Signup.toSignupPassenger());

        //Fill in all fields with valid information
        when(client).attemptsTo(
                SignupInfo.inputName("Xuan299"),
                SignupInfo.inputEmail("xuan299@gmail.com"),
                SignupInfo.inputPhoneNumber("0905743128"),
                SignupInfo.inputUserName("xuan12299"),
                SignupInfo.inputPassword("12345@Xuan"),
                SignupInfo.inputConfirmPassword("12345@Xuan"),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(SignupPage.MESSAGE_ALERT)).contains("Register successfully!")
        );
    }
}
