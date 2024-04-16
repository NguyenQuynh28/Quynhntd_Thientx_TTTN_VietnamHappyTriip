package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.PartnerPage;

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

}
