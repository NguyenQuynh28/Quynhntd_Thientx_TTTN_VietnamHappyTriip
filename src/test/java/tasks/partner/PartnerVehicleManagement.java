package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.PartnerPage;

public class PartnerVehicleManagement {
    public static Performable inputNameTransport(String value) {
        return Task.where("Enter name of transport",
                Actions.inputData(PartnerPage.TXT_NAME, value));
    }

    public static Performable chooseVehicleType(String value) {
        return Task.where("Choose vehicle type",
                Actions.chooseOption(PartnerPage.BTN_VEHICLE_TYPE, PartnerPage.LST_VEHICLE, value));
    }

    public static Performable addSeatType(String nameOfForNormalSeat, String descriptionOfForNormalSeat, String priceOfForNormalSeat,
                                          String nameOfForVipSeat, String descriptionOfForVipSeat, String priceOfForVipSeat, String row, String col) {
        return Task.where("Create seat type",
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
                Click.on(PartnerPage.BTN_COMPLETE)
        );
    }
}
