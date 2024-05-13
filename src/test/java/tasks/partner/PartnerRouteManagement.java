package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.Actions;
import ui.AdminPage;
import ui.PartnerPage;
import untils.WaitABit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PartnerRouteManagement {
    public static Performable inputNameRoute(String value) {
        return Task.where("Enter name of route",
                Actions.inputData(PartnerPage.TXT_NAME, value));
    }

    public static Performable inputPrice(String value) {
        return Task.where("Enter price",
                Actions.inputData(PartnerPage.TXT_PRICE, value));
    }

    public static Performable inputTime(Target target, String value) {
        return Task.where("Enter time",
                Click.on(target),
                Actions.inputData(target, value));
    }

    public static Performable inputDays(String value) {
        return Task.where("Enter days",
                Actions.inputData(PartnerPage.TXT_DAYS, value));
    }

    public static Performable chooseLocation(Target target, Target targetList, String value) {
        return Task.where("Choose Location",
                Actions.chooseOption(target, targetList, value));
    }

    public static Performable chooseTransport(Target target, Target targetList, String value) {
        return Task.where("Choose Transport",
                Actions.chooseOption(target, targetList, value));
    }

    public static Performable chooseSchedules(Target target, Target targetList, String value) {
        return Task.where("Choose Schedule",
                Actions.chooseOption(target, targetList, value));
    }

    public static Performable createRouteSuccess
            (String name, String price, String departTime, String arriveTime, String day,
             String from, String to, String schedules, String transport) {
        return Task.where("{0} create router success",
                PartnerNavbarNavigate.toRouteManagement(),
                PartnerRouteManagement.inputNameRoute(name),
                PartnerRouteManagement.inputPrice(price),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("depart-at"), departTime),
                PartnerRouteManagement.inputTime(PartnerPage.TXT_TIME.of("arrive-at"), arriveTime),
                PartnerRouteManagement.inputDays(day),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("fromAt "), PartnerPage.LST_LIST, from),
                PartnerRouteManagement.chooseLocation(PartnerPage.CKL_LOCATION.of("toAt "), PartnerPage.LST_LIST, to),
                PartnerRouteManagement.chooseSchedules(PartnerPage.CHK_CHOOSE_SCHEDULES, PartnerPage.CHK_CHOOSE_DAY, schedules),
                PartnerRouteManagement.chooseTransport(PartnerPage.CHK_CHOOSE_TRANSPORT, PartnerPage.LST_LIST, transport),
                Click.on(PartnerPage.BTN_SAVE),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static Performable chooseRouteInList(String name) {
        return Task.where("{0} choose route in list",
                Click.on(PartnerPage.BTN_CHOOSE_ROUTE_IN_LIST.of(name)),
                WaitABit.inSecond(3)
        );
    }
}
