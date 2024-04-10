package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import ui.ChangePasswordPopup;

public class ChangePasswordActions {
    public static Performable inputOldPassword(String value) {
        return Task.where("{0} enter old password: " + value,
                Actions.inputData(ChangePasswordPopup.TXT_OLD_PASSWORD, value)
        );
    }
    public static Performable inputNewPassword(String value) {
        return Task.where("{0} enter new password: " + value,
                Actions.inputData(ChangePasswordPopup.TXT_NEW_PASSWORD, value)
        );
    }
    public static Performable inputConfirmPassword(String value) {
        return Task.where("{0} enter confirm password: " + value,
                Actions.inputData(ChangePasswordPopup.TXT_CONFIRM_PASSWORD, value)
        );
    }
}
