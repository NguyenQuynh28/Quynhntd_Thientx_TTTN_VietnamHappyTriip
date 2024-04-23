package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import tasks.Actions;
import ui.PartnerPage;

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
                Actions.inputData(PartnerPage.TXT_TITLE, value));
    }
    public static Performable inputMediaLink(String value) {
        return Task.where("{0} enter media link: " + value,
                Actions.inputData(PartnerPage.TXT_MEDIA_LINK, value));
    }
    public static Performable inputDescription(String value) {
        return Task.where("{0} enter description: " + value,
                Actions.inputData(PartnerPage.TXT_DESCRIPTION, value));
    }
}
