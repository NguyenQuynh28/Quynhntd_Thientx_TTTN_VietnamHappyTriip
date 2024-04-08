package tests;

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
import tasks.admin.AdminProfileSettings;
import tasks.admin.AdminRouteManagement;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerRouteManagement;
import tasks.partner.PartnerVehicleManagement;
import ui.AdminPage;
import ui.PartnerPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminTest extends CommonTest {
    @Test
    @Tag("Admin_Test01")
    @Title("Admin_Test01: The Booking Confirmation is displayed")
    public void admin_test01() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toBookingConfirmation()
        );
        then(admin).should(
                seeThat("The Booking Confirmation is displayed", the(AdminPage.TITLE_BOOKING_CONFIRMATION), isVisible())
        );
    }

    @Test
    @Tag("Admin_Test13")
    @Title("Admin_Test13: The title Add New User is displayed")
    public void admin_test13() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser()
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TITLE_ADD_NEW_USER).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test14")
    @Title("Admin_Test14: Error [Name is required] is displayed")
    public void admin_test14() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Name" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Admin_Test15")
    @Title("Admin_Test15: Error [Name is required] is displayed")
    public void admin_test15() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Name" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("     "),
                AdminProfileSettings.inputEmailOfUser("employee40@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee40"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Admin_Test16")
    @Title("Admin_Test16: Error [Name is invalid] is displayed")
    public void admin_test16() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Name" field is >50 characters long
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee41111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111"),
                AdminProfileSettings.inputEmailOfUser("employee41@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee41"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Admin_Test17")
    @Title("Admin_Test17: Error [Email is required] is displayed")
    public void admin_test17() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Email" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is required")
        );
    }

    @Test
    @Tag("Admin_Test18")
    @Title("Admin_Test18: Error [Email must be a valid email] is displayed")
    public void admin_test18() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Email" field is filled including a space character
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee42"),
                AdminProfileSettings.inputEmailOfUser("     "),
                AdminProfileSettings.inputUserNameOfUser("employee42"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer"),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Admin_Test19")
    @Title("Admin_Test19: Error [Email must be a valid email] is displayed")
    public void admin_test19() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Email" field does not include the extension "@gmail.com"
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee43"),
                AdminProfileSettings.inputEmailOfUser("employee43"),
                AdminProfileSettings.inputUserNameOfUser("employee43"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer"),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Admin_Test20")
    @Title("Admin_Test20: Error [Email must be a valid email] is displayed")
    public void admin_test20() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Email" field is filled only "@gmail.com"
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee44"),
                AdminProfileSettings.inputEmailOfUser("@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee44"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer"),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Admin_Test21")
    @Title("Admin_Test21: Error [Username is required] is displayed")
    public void admin_test21() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Username" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Admin_Test22")
    @Title("Admin_Test22: Error [Username is required] is displayed")
    public void admin_test22() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Username" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee45"),
                AdminProfileSettings.inputEmailOfUser("employee45@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("          "),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Admin_Test23")
    @Title("Admin_Test23: Error [Username is invalid] is displayed")
    public void admin_test23() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Username" field is >50 characters long
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee46"),
                AdminProfileSettings.inputEmailOfUser("employee46@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee466666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is invalid")
        );
    }

    @Test
    @Tag("Admin_Test24")
    @Title("Admin_Test24: Message [Duplicate entry] is displayed")
    public void admin_test24() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Username" field matches an existing username
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee47"),
                AdminProfileSettings.inputEmailOfUser("employee47@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee6"),
                AdminProfileSettings.inputPasswordOfUser("1234Employeer@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer"),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_DUPLICATE_ENTRY)).contains("Duplicate entry")
        );
    }

    @Test
    @Tag("Admin_Test25")
    @Title("Admin_Test25: Error [Password is required] is displayed")
    public void admin_test25() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Password" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Admin_Test26")
    @Title("Admin_Test26: Error [Password is required] is displayed")
    public void admin_test26() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee48"),
                AdminProfileSettings.inputEmailOfUser("employee48@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee48"),
                AdminProfileSettings.inputPasswordOfUser("          "),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Admin_Test27")
    @Title("Admin_Test27: Error [Password is invalid] is displayed")
    public void admin_test27() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field is filled <8 characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee49"),
                AdminProfileSettings.inputEmailOfUser("employee49@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee49"),
                AdminProfileSettings.inputPasswordOfUser("1234Ee@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test28")
    @Title("Admin_Test28: Error [Password is invalid] is displayed")
    public void admin_test28() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field contains only numbers
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee50"),
                AdminProfileSettings.inputEmailOfUser("employee50@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee50"),
                AdminProfileSettings.inputPasswordOfUser("123456789"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test29")
    @Title("Admin_Test29: Error [Password is invalid] is displayed")
    public void admin_test29() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field has only lowercase letters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee51"),
                AdminProfileSettings.inputEmailOfUser("employee51@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee51"),
                AdminProfileSettings.inputPasswordOfUser("employeeeeeee"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test30")
    @Title("Admin_Test30: Error [Password is invalid] is displayed")
    public void admin_test30() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field has only uppercase letters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee52"),
                AdminProfileSettings.inputEmailOfUser("employee52@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee52"),
                AdminProfileSettings.inputPasswordOfUser("EMPLOYEE"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test31")
    @Title("Admin_Test31: Error [Password is invalid] is displayed")
    public void admin_test31() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field contains only special characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee53"),
                AdminProfileSettings.inputEmailOfUser("employee53@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee53"),
                AdminProfileSettings.inputPasswordOfUser("@@@@@@@@@@"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test32")
    @Title("Admin_Test32: Error [Password is invalid] is displayed")
    public void admin_test32() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field contains only special characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee54"),
                AdminProfileSettings.inputEmailOfUser("employee54@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee54"),
                AdminProfileSettings.inputPasswordOfUser("1234Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test33")
    @Title("Admin_Test33: Error [Phone number is required] is displayed")
    public void admin_test33() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Phone number" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Admin_Test34")
    @Title("Admin_Test34: Error [Phone number is required] is displayed")
    public void admin_test34() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee55"),
                AdminProfileSettings.inputEmailOfUser("employee55@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee55"),
                AdminProfileSettings.inputPasswordOfUser("1234@Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("          "),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Admin_Test35")
    @Title("Admin_Test35: Error [Phone number is invalid] is displayed")
    public void admin_test35() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field is filled a phone number <7 numeric characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee56"),
                AdminProfileSettings.inputEmailOfUser("employee56@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee56"),
                AdminProfileSettings.inputPasswordOfUser("1234@Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("04537"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Admin_Test36")
    @Title("Admin_Test36: Error [Phone number is invalid] is displayed")
    public void admin_test36() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field is filled a phone number >12 numeric characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee57"),
                AdminProfileSettings.inputEmailOfUser("employee57@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee57"),
                AdminProfileSettings.inputPasswordOfUser("1234@Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("04537684316536"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Admin_Test37")
    @Title("Admin_Test37: Error [Phone number is invalid] is displayed")
    public void admin_test37() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field contains non-numeric characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee58"),
                AdminProfileSettings.inputEmailOfUser("employee58@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee58"),
                AdminProfileSettings.inputPasswordOfUser("1234@Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("ttteeehhhhttttt"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer")
//                Click.on(AdminPage.BTN_SAVE_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Admin_Test38")
    @Title("Admin_Test38: Error [Employee role is required] is displayed")
    public void admin_test38() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not choose "Employee Role" option
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Employee role"))).isEqualTo("Employee role is required")
        );
    }

    @Test
    @Tag("Admin_Test39")
    @Title("Admin_Test39: Message [Employee is created successfully] is displayed")
    public void admin_test39() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and fill in all fields with valid information
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee60"),
                AdminProfileSettings.inputEmailOfUser("employee60@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser("employee60"),
                AdminProfileSettings.inputPasswordOfUser("1234@Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer"),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Employee is created successfully")
        );
    }

    @Test
    @Tag("Admin_Test40")
    @Title("Admin_Test40: The [Add New User] page is no longer displayed.")
    public void admin_test40() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and click button cancel
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                Click.on(AdminPage.BTN_CANCEL_NEW_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TITLE_ADD_NEW_USER).isNotDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test41")
    @Title("Admin_Test41: Message [No bookings found.] is displayed")
    public void admin_test41() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Profile & Settings page and search user
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                Actions.inputData(AdminPage.TXT_SEARCH, "employee100")
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.MESSAGE_SEARCH_USER).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test42")
    @Title("Admin_Test42: Display the name of the user to search for.")
    public void admin_test42() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Profile & Settings page and search user
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                Actions.inputData(AdminPage.TXT_SEARCH, "employee1")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.LBL_LIST_USER)).contains("employee1")
        );
    }

    @Test
    @Tag("Admin_Test43")
    @Title("Admin_Test43: Update user information")
    public void admin_test43() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Profile & Settings page and update user information
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                Click.on(AdminPage.LBL_USER.of("employee555")),
                AdminProfileSettings.inputNameOfUser("employee62"),
                WaitABit.inSecond(2),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).contains("Employee is updated successfully")
        );
    }

    @Test
    @Tag("Admin_Test44")
    @Title("Admin_Test44: Update user information")
    public void admin_test44() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Profile & Settings page and remove user
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                Click.on(AdminPage.LBL_USER.of("employee4")),
                Click.on(AdminPage.BTN_REMOVE_USER)
        );
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LBL_USER.of("employee4")).isNotDisplayed()
        );
    }


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

