package tests.admin;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Actions;
import tasks.Login;
import tasks.Signup;
import tasks.SignupInfo;
import tasks.admin.AdminNavbarNavigate;
import tasks.admin.AdminProfileSettings;
import tests.CommonTest;
import ui.AdminPage;
import ui.SignupPage;
import untils.WaitABit;

import java.util.Random;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("AdminProfileSettingsTest")
public class AdminProfileSettingsTest extends CommonTest {
    @Test
    @Tag("Admin_Test13")
    @Title("Admin_Test13: The title Add New User is displayed")
    public void admin_test13() {
        clientBrowser.close();
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
        clientBrowser.close();
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
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Name" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser(DataTest.spaceCharacter)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Admin_Test16")
    @Title("Admin_Test16: Error [Name is invalid] is displayed")
    public void admin_test16() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Name" field is >50 characters long
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser(DataTest.over50char)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Admin_Test17")
    @Title("Admin_Test17: Error [Email is required] is displayed")
    public void admin_test17() {
        clientBrowser.close();
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
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Email" field is filled including a space character
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser("employee42"),
                AdminProfileSettings.inputEmailOfUser(DataTest.spaceCharacter),
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
        clientBrowser.close();
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
        clientBrowser.close();
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
        clientBrowser.close();
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
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Username" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputUserNameOfUser(DataTest.spaceCharacter)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is required")
        );
    }

    @Test
    @Tag("Admin_Test23")
    @Title("Admin_Test23: Error [Username is invalid] is displayed")
    public void admin_test23() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Username" field is >50 characters long
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputUserNameOfUser(DataTest.over50char)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Username"))).isEqualTo("Username is invalid")
        );
    }

    @Test
    @Tag("Admin_Test24")
    @Title("Admin_Test24: Message [Duplicate entry] is displayed")
    public void admin_test24() {
        clientBrowser.close();
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
                WaitUntil.the(AdminPage.MESSAGE_DUPLICATE_ENTRY, WebElementStateMatchers.isVisible()),
                Ensure.that(Text.of(AdminPage.MESSAGE_DUPLICATE_ENTRY)).contains("Duplicate entry")
        );
    }

    @Test
    @Tag("Admin_Test25")
    @Title("Admin_Test25: Error [Password is required] is displayed")
    public void admin_test25() {
        clientBrowser.close();
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
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser(DataTest.spaceCharacter)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is required")
        );
    }

    @Test
    @Tag("Admin_Test27")
    @Title("Admin_Test27: Error [Password is invalid] is displayed")
    public void admin_test27() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field is filled <8 characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser("1234Ee@")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test28")
    @Title("Admin_Test28: Error [Password is invalid] is displayed")
    public void admin_test28() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field contains only numbers
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser("123456789")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test29")
    @Title("Admin_Test29: Error [Password is invalid] is displayed")
    public void admin_test29() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field has only lowercase letters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser("employeeeeeee")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test30")
    @Title("Admin_Test30: Error [Password is invalid] is displayed")
    public void admin_test30() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field has only uppercase letters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser("EMPLOYEE")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test31")
    @Title("Admin_Test31: Error [Password is invalid] is displayed")
    public void admin_test31() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field contains only special characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser("@@@@@@@@@@")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test32")
    @Title("Admin_Test32: Error [Password is invalid] is displayed")
    public void admin_test32() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Password" field does not include 4 types of characters: lowercase, letters, uppercase letters, numbers and special characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPasswordOfUser("1234Employee")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Password"))).isEqualTo("Password is invalid")
        );
    }

    @Test
    @Tag("Admin_Test33")
    @Title("Admin_Test33: Error [Phone number is required] is displayed")
    public void admin_test33() {
        clientBrowser.close();
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
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field is filled with space characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPhoneNumberOfUser(DataTest.spaceCharacter)
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Admin_Test35")
    @Title("Admin_Test35: Error [Phone number is invalid] is displayed")
    public void admin_test35() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field is filled a phone number <7 numeric characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPhoneNumberOfUser("04537")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Admin_Test36")
    @Title("Admin_Test36: Error [Phone number is invalid] is displayed")
    public void admin_test36() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field is filled a phone number >12 numeric characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPhoneNumberOfUser("04537684316536")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Admin_Test37")
    @Title("Admin_Test37: Error [Phone number is invalid] is displayed")
    public void admin_test37() {
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and the "Phone number" field contains non-numeric characters
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputPhoneNumberOfUser("ttteeehhhhttttt")
        );
        then(admin).attemptsTo(
                Ensure.that(Text.of(AdminPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Admin_Test38")
    @Title("Admin_Test38: Error [Employee role is required] is displayed")
    public void admin_test38() {
        clientBrowser.close();
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
        clientBrowser.close();
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and fill in all fields with valid information
        Random rand = new Random();
        int randomNumber = rand.nextInt(9000) + 1000;
        String data = "employee" + randomNumber;
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminProfileSettings.toAddNewUser(),
                AdminProfileSettings.inputNameOfUser(data),
                AdminProfileSettings.inputEmailOfUser(data + "@gmail.com"),
                AdminProfileSettings.inputUserNameOfUser(data),
                AdminProfileSettings.inputPasswordOfUser("1234@Employee"),
                AdminProfileSettings.inputPhoneNumberOfUser("0453768431"),
                AdminProfileSettings.chooseEmployeeRoleUser("Viewer"),
                Click.on(AdminPage.BTN_SAVE_USER)
        );
        then(admin).attemptsTo(
                WaitUntil.the(AdminPage.MESSAGE_SUCCESSFULLY, WebElementStateMatchers.isVisible()),
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Employee is created successfully")
        );
    }

    @Test
    @Tag("Admin_Test40")
    @Title("Admin_Test40: The [Add New User] page is no longer displayed.")
    public void admin_test40() {
        clientBrowser.close();
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
        clientBrowser.close();
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
        clientBrowser.close();
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
        clientBrowser.close();
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
                WaitUntil.the(AdminPage.MESSAGE_SUCCESSFULLY, WebElementStateMatchers.isVisible()),
                Ensure.that(Text.of(AdminPage.MESSAGE_SUCCESSFULLY)).contains("Employee is updated successfully")
        );
    }

    @Test
    @Tag("Admin_Test44")
    @Title("Admin_Test44: Update user information")
    public void admin_test44() {
        clientBrowser.close();
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
}
