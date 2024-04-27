package tests.partner;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.partner.PartnerManagement;
import tasks.partner.PartnerNavbarNavigate;
import tests.CommonTest;
import ui.PartnerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PartnerManagementTest")
public class PartnerManagementTest extends CommonTest {
    @Test
    @Tag("Partner_Test51")
    @Title("Partner_Test51: Navigates to the “Partner profile” page")
    public void partner_test51() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement()
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TITLE_PARTNER_PROFILE).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test81")
    @Title("Partner_Test81: Error [Name is required] is displayed")
    public void partner_test81() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Name" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_NAME),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Name"))).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test82")
    @Title("Partner_Test82: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test82() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Name" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputNamePartner("Partner 3"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test83")
    @Title("Partner_Test83: Error [Tax Code is required] is displayed")
    public void partner_test83() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Tax Code" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_TAX_CODE),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Tax Code"))).isEqualTo("Tax Code is required")
        );
    }

    @Test
    @Tag("Partner_Test84")
    @Title("Partner_Test84: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test84() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Tax Code" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputTaxCode("0402118154"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test85")
    @Title("Partner_Test85: Error [Address is required] is displayed")
    public void partner_test85() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Address" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_ADDRESS),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Address"))).isEqualTo("Address is required")
        );
    }

    @Test
    @Tag("Partner_Test86")
    @Title("Partner_Test86: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test86() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Address" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputAddress("Âu Cơ, Phường Hoà Khánh Bắc, Quận Liên Chiểu, Thành phố Đà Nẵng, Việt Nam"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test87")
    @Title("Partner_Test87: Error [Email is required] is displayed")
    public void partner_test87() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Email" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_EMAIL),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Email"))).isEqualTo("Email is required")
        );
    }

    @Test
    @Tag("Partner_Test88")
    @Title("Partner_Test88: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test88() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Email" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputEmail("partner@gmail.com"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test89")
    @Title("Partner_Test89: Error [Phone number is required] is displayed")
    public void partner_test89() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Phone number" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_PHONE_NUMBER),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Phone number"))).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Partner_Test90")
    @Title("Partner_Test90: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test90() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Phone number" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputPhoneNumber("0123456789"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test91")
    @Title("Partner_Test91: Error [Title is required] is displayed")
    public void partner_test91() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Title" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_TITLE_PARTNER),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Title"))).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test92")
    @Title("Partner_Test92: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test92() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Title" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputTitle("partner"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test93")
    @Title("Partner_Test93: Error [MedialLink is required] is displayed")
    public void partner_test93() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "MedialLink" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_MEDIA_LINK),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("MedialLink"))).isEqualTo("MedialLink is required")
        );
    }

    @Test
    @Tag("Partner_Test94")
    @Title("Partner_Test94: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test94() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "MedialLink" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputMediaLink("partner@gmail.com"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test95")
    @Title("Partner_Test95: Error [Description is required] is displayed")
    public void partner_test95() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and clear the "Description" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                Clear.field(PartnerPage.TXT_DESCRIPTION_PARTNER),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE.of("Description"))).isEqualTo("Description is required")
        );
    }

    @Test
    @Tag("Partner_Test96")
    @Title("Partner_Test96: Error [Partner profile is in view mode because it was accepted!] is displayed")
    public void partner_test96() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Partner profile page and update the "Description" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputDescription("partner"),
                Click.on(PartnerPage.BTN_SAVE)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.ERROR_PARTNER_ACCEPTED).isDisplayed()
        );
    }
}
