package tasks.passenger;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import tasks.Actions;
import ui.PassengerPage;

public class PassengerManagement {
    public static Performable clickUpdate(){
        return Task.where("Click button update",
                Click.on(PassengerPage.BTN_UPDATE));
    }
    public static Performable inputName(String value){
        return Task.where("Input name",
                Actions.inputData(PassengerPage.TXT_NAME, value));
    }
    public static Performable inputEmail(String value){
        return Task.where("Input Email",
                Actions.inputData(PassengerPage.TXT_EMAIL, value));
    }
    public static Performable inputPhoneNumber(String value){
        return Task.where("Input Phome number",
                Actions.inputData(PassengerPage.TXT_PHONE_NUMBER, value));
    }
    public static Performable clickSave(){
        return Task.where("Save information",
                Click.on(PassengerPage.BTN_SAVE));
    }
    public static Performable removeText(Target target){
        return Task.where("Remove text",
                Clear.field(target));
    }
}
