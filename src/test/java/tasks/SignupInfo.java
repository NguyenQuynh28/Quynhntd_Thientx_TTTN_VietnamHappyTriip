package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import ui.SignupPage;

public class SignupInfo {
    public static Performable inputName(String value) {
        return Task.where("{0} enter name: " + value,
                Actions.inputData(SignupPage.TXT_NAME, value)
        );
    }

    public static Performable inputEmail(String value) {
        return Task.where("{0} enter email: " + value,
                Actions.inputData(SignupPage.TXT_EMAIL, value)
        );
    }

    public static Performable inputPhoneNumber(String value) {
        return Task.where("{0} enter phone number: " + value,
                Actions.inputData(SignupPage.TXT_PHONE_NUMBER, value)
        );
    }

    public static Performable inputUserName(String value) {
        return Task.where("{0} enter username: " + value,
                Actions.inputData(SignupPage.TXT_USERNAME, value)
        );
    }

    public static Performable inputPassword(String value) {
        return Task.where("{0} enter password: " + value,
                Actions.inputData(SignupPage.TXT_PASSWORD, value)
        );
    }

    public static Performable inputConfirmPassword(String value) {
        return Task.where("{0} enter confirm password: " + value,
                Actions.inputData(SignupPage.TXT_CONFIRM_PASSWORD, value)
        );
    }
}
