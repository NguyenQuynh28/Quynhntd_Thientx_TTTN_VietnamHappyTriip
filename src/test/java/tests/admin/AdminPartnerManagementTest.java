package tests.admin;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Browser;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminChoosePartner;
import tasks.admin.AdminNavbarNavigate;
import tasks.admin.AdminPartnerManagement;
import tasks.partner.PartnerManagement;
import tasks.partner.SignupPartner;
import tests.CommonTest;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("AdminPartnerManagementTest")
public class AdminPartnerManagementTest extends CommonTest {

    @Test
    @Tag("Admin_Test79")
    @Title("Test79: The system displays a popup with the text 'Partner details'")
    public void test79(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        then(admin).attemptsTo(
                Ensure.that(AdminPage.POPUP_PARTNER_DETAIL).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test80")
    @Title("Test80: The system displays a popup with the text 'Are you sure that you want to accept this partner?'")
    public void test80(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        //3.The system displays a popup. Click the "Accept" button.
        andThat(admin).attemptsTo(AdminPartnerManagement.acceptPartner());
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ALERT_CONFIRM).isDisplayed(),
                Ensure.that(AdminPage.ALERT_CONFIRM).hasText("Are you sure that you want to accept this partner?")
        );
    }

    @Test
    @Tag("Admin_Test81")
    @Title("Test81: The system returns to the 'Partner details' page")
    public void test81(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        //3.The system displays a popup. Click on the "Accept" button. and 4.The system displays a pop-up. Click the "No" button.
        andThat(admin).attemptsTo(AdminPartnerManagement.noAcceptPartner());
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ALERT_CONFIRM).isNotDisplayed(),
                Ensure.that(AdminPage.POPUP_PARTNER_DETAIL).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test82")
    @Title("Test82: The system displays the message 'This partner is accepted successfully!'")
    public void test82(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        //3.The system displays a popup. Click on the "Accept" button. and 4.The system displays a pop-up. Click the "No" button.
        andThat(admin).attemptsTo(AdminPartnerManagement.yesAcceptPartner());
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(AdminPage.TOAST_MESSAGE).hasText("This partner is accepted successfully!")
        );
    }

    @Test
    @Tag("Admin_Test83")
    @Title("Test83: The system displays a popup with the text 'Are you sure that you want to deny this partner?'")
    public void test83(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        //3.The system displays a popup. Click the "Deny" button.
        andThat(admin).attemptsTo(AdminPartnerManagement.denyPartner());
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ALERT_CONFIRM).isDisplayed(),
                Ensure.that(AdminPage.ALERT_CONFIRM).hasText("Are you sure that you want to deny this partner?")
        );
    }
    @Test
    @Tag("Admin_Test84")
    @Title("Test84: The system returns to the 'Partner details' page")
    public void test84(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        //3.The system displays a popup. Click on the "Deny" button. and 4.The system displays a pop-up. Click the "No" button.
        andThat(admin).attemptsTo(AdminPartnerManagement.noDenyPartner());
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ALERT_CONFIRM).isNotDisplayed(),
                Ensure.that(AdminPage.POPUP_PARTNER_DETAIL).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test85")
    @Title("Test85: The system displays the message 'This partner is denied successfully!'")
    public void test85(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "Pending".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusPending(SignupPartner.getUserName()));
        //3.The system displays a popup. Click on the "Deny" button. and 4.The system displays a pop-up. Click the "No" button.
        andThat(admin).attemptsTo(AdminPartnerManagement.yesDenyPartner());
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(AdminPage.TOAST_MESSAGE).hasText("This partner is denied successfully!")
        );
    }

    @Test
    @Tag("Admin_Test86")
    @Title("Test86: The system displays a popup 'Partner details' containing partner information.")
    public void test86(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
                        .then(PartnerManagement.inputCompleteData(
                                DataTest.taxCode,
                                DataTest.address,
                                "TesterAutomation",
                                "TesterAutomation",
                                "TesterAutomation"
                        ))
        );
        //The admin performs the acceptance.
        andThat(admin).attemptsTo(
                AdminNavbarNavigate.toPartnerManagement(),
                AdminChoosePartner.withStatusPending(SignupPartner.getUserName()),
                AdminPartnerManagement.yesAcceptPartner()
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(
                Browser.refreshPage(),
                AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "ACCEPT".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusAccept(SignupPartner.getUserName()));
        then(admin).attemptsTo(
                Ensure.that(AdminPage.POPUP_PARTNER_DETAIL).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test87")
    @Title("Test87: The system displays a popup titled 'Partner details' containing partner information.'")
    public void test87(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Create a partner account then Login to partner Page.
        andThat(client).attemptsTo(
                SignupPartner.signupSuccess()
                        .then(Login.toPartnerPage().withNewPartner())
        );
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.On the Partner Management page, select any partner information with the status "INCOMPLETE DATA".
        andThat(admin).attemptsTo(AdminChoosePartner.withStatusImcompleteData(SignupPartner.getUserName()));
        then(admin).attemptsTo(
                Ensure.that(AdminPage.POPUP_PARTNER_DETAIL).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test88")
    @Title("Test88: The system displays the message 'No bookings found.'")
    public void test88(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.In the text box, enter information for a Partner that does not exist.
        andThat(admin).attemptsTo(AdminPartnerManagement.searchPartner("PartnerNoResult"));
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LBL_NO_PARTNER_FOUND).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test89")
    @Title("Test89: The system displays information similar to the entered data.")
    public void test89(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.In the text box, enter information for a Partner that already exists in the system.
        andThat(admin).attemptsTo(AdminPartnerManagement.searchPartner("partner30"));
        then(admin).attemptsTo(
                Ensure.that(AdminPage.PARTNER_SEARCH_RESULT.of("partner30")).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test90")
    @Title("Test90: The system displays all partners.")
    public void test90(){
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Click on the "Partner Management" button on the left navigation bar of the screen.
        when(admin).attemptsTo(AdminNavbarNavigate.toPartnerManagement());
        //2.In the text box, enter information for a Partner that already exists in the system.
        andThat(admin).attemptsTo(AdminPartnerManagement.searchPartner("partner30"));
        //3.The system displays the information just searched for, then click on the "Clear" button.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_CLEAR_SEARCH));
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LIST_PARTNER_MANAGEMENT).isDisplayed()
        );
    }
}
