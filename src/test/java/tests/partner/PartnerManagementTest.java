package tests.partner;

import helpers.TakeScreenshot;
import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import questions.CompareImage;
import tasks.Login;
import tasks.Login_Partner30;
import tasks.RefreshPage;
import tasks.partner.PartnerManagement;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerTransportManagement;
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
    @Tag("Partner_Test52")
    @Title("Partner_Test52: [Name is required] is displayed")
    public void partner_test52() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_NAME)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test53")
    @Title("Partner_Test53: [Name is required] is displayed")
    public void partner_test53() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Name is required")
        );
    }

    @Test
    @Tag("Partner_Test54")
    @Title("Partner_Test54: [Name is invalid] is displayed")
    public void partner_test54() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner(DataTest.over50char)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Name is invalid")
        );
    }

    @Test
    @Tag("Partner_Test55")
    @Title("Partner_Test55: [Profile update successful!] is displayed when a valid name is entered")
    public void partner_test55() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 31"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner31@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner31"),
                PartnerTransportManagement.inputMediaLinkPartner("partner31@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner31")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Profile updated successfully!")
        );
    }

    @Test
    @Tag("Partner_Test56")
    @Title("Partner_Test56: [Tax Code is required] is displayed")
    public void partner_test56() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_TAX_CODE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Tax Code is required")
        );
    }

    @Test
    @Tag("Partner_Test57")
    @Title("Partner_Test57: [Tax Code is required] is displayed")
    public void partner_test57() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Tax Code is required")
        );
    }

    @Test
    @Tag("Partner_Test58")
    @Title("Partner_Test58: [Tax invalid - Mã số thuế không chính xác] is displayed")
    public void partner_test58() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 32"),
                PartnerTransportManagement.inputTaxCodePartner("12345"),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner32@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner32"),
                PartnerTransportManagement.inputMediaLinkPartner("partner32@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner32")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Tax invalid - Mã số thuế không chính xác")
        );
    }

    @Test
    @Tag("Partner_Test59")
    @Title("Partner_Test59: [Tax not found - Mã số thuế không tồn tại] is displayed")
    public void partner_test59() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 33"),
                PartnerTransportManagement.inputTaxCodePartner("123456789101112"),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner33@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner33"),
                PartnerTransportManagement.inputMediaLinkPartner("partner33@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner33")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Tax not found - Mã số thuế không tồn tại")
        );
    }

    @Test
    @Tag("Partner_Test60")
    @Title("Partner_Test60: [Tax not found - Mã số thuế không tồn tại] is displayed")
    public void partner_test60() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 34"),
                PartnerTransportManagement.inputTaxCodePartner("aaaaaaaaaa"),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner34@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner34"),
                PartnerTransportManagement.inputMediaLinkPartner("partner34@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner34")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Tax not found - Mã số thuế không tồn tại")
        );
    }

    @Test
    @Tag("Partner_Test61")
    @Title("Partner_Test61: [Address is required] is displayed")
    public void partner_test61() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_ADDRESS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Address is required")
        );
    }

    @Test
    @Tag("Partner_Test62")
    @Title("Partner_Test62: [Address is required] is displayed")
    public void partner_test62() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputAddressPartner(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Address is required")
        );
    }

    @Test
    @Tag("Partner_Test63")
    @Title("Partner_Test63: [Address is invalid] is displayed")
    public void partner_test63() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 35"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.over100char),
                PartnerTransportManagement.inputEmailPartner("partner33@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner35"),
                PartnerTransportManagement.inputMediaLinkPartner("partner35@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner35")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Address is invalid")
        );
    }

    @Test
    @Tag("Partner_Test64")
    @Title("Partner_Test64: [Email is required] is displayed")
    public void partner_test64() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_EMAIL)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Email is required")
        );
    }

    @Test
    @Tag("Partner_Test65")
    @Title("Partner_Test65: [Email must be a valid email] is displayed")
    public void partner_test65() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputEmailPartner(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Partner_Test66")
    @Title("Partner_Test66: [Email must be a valid email] is displayed")
    public void partner_test66() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputEmailPartner("partner30")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Partner_Test67")
    @Title("Partner_Test67: [Email must be a valid email] is displayed")
    public void partner_test67() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputEmailPartner("@gmail.com")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Email must be a valid email")
        );
    }

    @Test
    @Tag("Partner_Test68")
    @Title("Partner_Test68: [Phone number is required] is displayed")
    public void partner_test68() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_PHONE_NUMBER)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Partner_Test69")
    @Title("Partner_Test69: [Phone number is required] is displayed")
    public void partner_test69() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.spaceCharacter)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Phone number is required")
        );
    }

    @Test
    @Tag("Partner_Test70")
    @Title("Partner_Test70: [Phone number is invalid] is displayed")
    public void partner_test70() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 36"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner36@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner("01234"),
                PartnerTransportManagement.inputTitlePartner("partner36"),
                PartnerTransportManagement.inputMediaLinkPartner("partner36@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner36")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Partner_Test71")
    @Title("Partner_Test71: [Phone number is invalid] is displayed")
    public void partner_test71() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 37"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner37@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner("012345678901112"),
                PartnerTransportManagement.inputTitlePartner("partner37"),
                PartnerTransportManagement.inputMediaLinkPartner("partner37@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner37")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Partner_Test72")
    @Title("Partner_Test72: [Phone number is invalid] is displayed")
    public void partner_test72() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 38"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner38@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner("aaaaaaaaaa"),
                PartnerTransportManagement.inputTitlePartner("partner38"),
                PartnerTransportManagement.inputMediaLinkPartner("partner38@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner38")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Phone number is invalid")
        );
    }

    @Test
    @Tag("Partner_Test73")
    @Title("Partner_Test73: [Title is required] is displayed")
    public void partner_test73() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_TITLE_PARTNER)

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test74")
    @Title("Partner_Test74: [Title is required] is displayed")
    public void partner_test74() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputTitlePartner(DataTest.spaceCharacter)

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test75")
    @Title("Partner_Test75: [MedialLink is required] is displayed")
    public void partner_test75() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_MEDIA_LINK)

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("MedialLink is required")
        );
    }

    @Test
    @Tag("Partner_Test76")
    @Title("Partner_Test76: [MedialLink is required] is displayed")
    public void partner_test76() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputMediaLinkPartner(DataTest.spaceCharacter)

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("MedialLink is required")
        );
    }

    @Test
    @Tag("Partner_Test77")
    @Title("Partner_Test77: [Description is required] is displayed")
    public void partner_test77() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.deleteData(PartnerPage.TXT_DESCRIPTION_PARTNER)

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Description is required")
        );
    }

    @Test
    @Tag("Partner_Test78")
    @Title("Partner_Test78: [Description is required] is displayed")
    public void partner_test78() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputDescriptionPartner(DataTest.spaceCharacter)

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_ERROR)).isEqualTo("Description is required")
        );
    }

    /**
     * còn verify
     */
    @Test
    @Tag("Partner_Test79")
    @Title("Partner_Test79: The information does not change after clicking cancel")
    public void partner_test79() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                TakeScreenshot.ofElement(PartnerPage.TAKE_SCREENSHOT_PARTNER_PROFILE, "partnerProfileBeforeIMG"),
                PartnerTransportManagement.inputNamePartner("Partner 32"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner32@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner32"),
                PartnerTransportManagement.inputMediaLinkPartner("partner32@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner32"),
                Click.on(PartnerPage.BTN_CANCEL_INFO_PARTNER),
                RefreshPage.refreshPage()
                        .then(
                                TakeScreenshot.ofElement(PartnerPage.TAKE_SCREENSHOT_PARTNER_PROFILE, "partnerProfileAfterIMG")
                        )
        );
        then(admin).should(
                seeThat("The image is compared", CompareImage.imgProfilePartner())
        );

    }

    @Test
    @Tag("Partner_Test80")
    @Title("Partner_Test80: Partner information has been successfully updated ")
    public void partner_test80() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login_Partner30.toPartner30Page());

        //Navigate to Partner profile page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerTransportManagement.inputNamePartner("Partner 32"),
                PartnerTransportManagement.inputTaxCodePartner(DataTest.taxCode),
                PartnerTransportManagement.inputAddressPartner(DataTest.address),
                PartnerTransportManagement.inputEmailPartner("partner32@gmail.com"),
                PartnerTransportManagement.inputPhoneNumberPartner(DataTest.phoneNumber),
                PartnerTransportManagement.inputTitlePartner("partner32"),
                PartnerTransportManagement.inputMediaLinkPartner("partner32@gmail.com"),
                PartnerTransportManagement.inputDescriptionPartner("partner32")
                        .then(
                                Click.on(PartnerPage.BTN_SAVE)
                        )

        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("Profile updated successfully!")
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
                PartnerManagement.inputTaxCode(DataTest.taxCode),
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
}
