package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import tasks.Actions;
import ui.PartnerPage;
import untils.WaitABit;

public class PartnerTransportManagement {
    public static Performable inputNameTransport(String value) {
        return Task.where("{0} enter name of transport: " + value,
                Actions.inputData(PartnerPage.TXT_NAME, value));
    }

    public static Performable chooseVehicleType(String value) {
        return Task.where("{0} choose vehicle type: " + value,
                Actions.chooseOption(PartnerPage.BTN_VEHICLE_TYPE, PartnerPage.LST_VEHICLE, value));
    }

    public static Performable addSeatType(String nameOfForNormalSeat, String descriptionOfForNormalSeat, String priceOfForNormalSeat,
                                          String nameOfForVipSeat, String descriptionOfForVipSeat, String priceOfForVipSeat, String row, String col) {
        return Task.where("{0} create seat type",
                Click.on(PartnerPage.BTN_SEAT_TYPE),
                Actions.inputData(PartnerPage.TXT_NORMAL_SEAT, nameOfForNormalSeat),
                Actions.inputData(PartnerPage.TXT_NORMAL_SEAT_DESCRIPTION, descriptionOfForNormalSeat),
                Actions.inputData(PartnerPage.TXT_NORMAL_SEAT_PRICE, priceOfForNormalSeat),
                Actions.inputData(PartnerPage.TXT_VIP_SEAT, nameOfForVipSeat),
                Actions.inputData(PartnerPage.TXT_VIP_SEAT_DESCRIPTION, descriptionOfForVipSeat),
                Actions.inputData(PartnerPage.TXT_VIP_SEAT_PRICE, priceOfForVipSeat),
                Click.on(PartnerPage.BTN_NEXT),
                Actions.inputData(PartnerPage.TXT_ROW, row),
                Actions.inputData(PartnerPage.TXT_COL, col),
                Click.on(PartnerPage.BTN_CONFIRM),
                Click.on(PartnerPage.BTN_VIP_SEAT_TYPE),
                Click.on(PartnerPage.BTN_VIP_SEAT),
                Click.on(PartnerPage.BTN_COMPLETE)
        );
    }

    public static Performable importImage(String value, String type) {
        return Task.where("{0} import image",
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, value, type)
        );
    }

    public static Performable deleteData(Target target) {
        return Task.where("{0} delete data",
                Clear.field(target)
        );
    }

    public static Performable inputNamePartner(String value) {
        return Task.where("{0} enter name of transport: " + value,
                Actions.inputData(PartnerPage.TXT_NAME, value));
    }

    public static Performable inputTaxCodePartner(String value) {
        return Task.where("{0} enter tax code of transport: " + value,
                Actions.inputData(PartnerPage.TXT_TAX_CODE, value));
    }

    public static Performable inputAddressPartner(String value) {
        return Task.where("{0} enter address of transport: " + value,
                Actions.inputData(PartnerPage.TXT_ADDRESS, value));
    }

    public static Performable inputEmailPartner(String value) {
        return Task.where("{0} enter email of transport: " + value,
                Actions.inputData(PartnerPage.TXT_EMAIL, value));
    }

    public static Performable inputPhoneNumberPartner(String value) {
        return Task.where("{0} enter phone number of transport: " + value,
                Actions.inputData(PartnerPage.TXT_PHONE_NUMBER, value));
    }

    public static Performable inputTitlePartner(String value) {
        return Task.where("{0} enter title of transport: " + value,
                Actions.inputData(PartnerPage.TXT_TITLE_PARTNER, value));
    }

    public static Performable inputMediaLinkPartner(String value) {
        return Task.where("{0} enter media link of transport: " + value,
                Actions.inputData(PartnerPage.TXT_MEDIA_LINK, value));
    }

    public static Performable inputDescriptionPartner(String value) {
        return Task.where("{0} enter description of transport: " + value,
                Actions.inputData(PartnerPage.TXT_DESCRIPTION_PARTNER, value));
    }

}
