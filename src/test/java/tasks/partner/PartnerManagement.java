package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.Actions;
import ui.AdminPage;
import ui.PartnerPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PartnerManagement {
    public static Performable inputNamePartner(String value) {
        return Task.where("{0} enter name of partner: " + value,
                Actions.inputData(PartnerPage.TXT_NAME, value));
    }

    public static Performable inputTaxCode(String value) {
        return Task.where("{0} enter Tax Code: " + value,
                Actions.inputData(PartnerPage.TXT_TAX_CODE, value));
    }

    public static Performable inputAddress(String value) {
        return Task.where("{0} enter address: " + value,
                Actions.inputData(PartnerPage.TXT_ADDRESS, value));
    }

    public static Performable inputEmail(String value) {
        return Task.where("{0} enter email: " + value,
                Actions.inputData(PartnerPage.TXT_EMAIL, value));
    }

    public static Performable inputPhoneNumber(String value) {
        return Task.where("{0} enter phone number: " + value,
                Actions.inputData(PartnerPage.TXT_PHONE_NUMBER, value));
    }

    public static Performable inputTitle(String value) {
        return Task.where("{0} enter title: " + value,
                Actions.inputData(PartnerPage.TXT_TITLE_PARTNER, value));
    }

    public static Performable inputMediaLink(String value) {
        return Task.where("{0} enter media link: " + value,
                Actions.inputData(PartnerPage.TXT_MEDIA_LINK, value));
    }

    public static Performable inputDescription(String value) {
        return Task.where("{0} enter description: " + value,
                Actions.inputData(PartnerPage.TXT_DESCRIPTION_PARTNER, value));
    }

    public static Performable inputCompleteData(String taxCode, String address, String title, String mediaLink, String description) {
        return Task.where("{0} input completeData",
                PartnerNavbarNavigate.toPartnerManagement(),
                PartnerManagement.inputTaxCode(taxCode),
                PartnerManagement.inputAddress(address),
                Actions.inputData(PartnerPage.TXT_TITLE_PARTNER, title),
                PartnerManagement.inputMediaLink(mediaLink),
                Actions.inputData(PartnerPage.TXT_DESCRIPTION_PARTNER, description)
                        .then(Click.on(PartnerPage.BTN_SAVE_PARTNER)),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isNotVisible()).forNoMoreThan(120).seconds()
        );
    }
}
