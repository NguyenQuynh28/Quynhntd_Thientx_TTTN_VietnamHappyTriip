package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import tasks.Actions;
import ui.PartnerPage;

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
}
