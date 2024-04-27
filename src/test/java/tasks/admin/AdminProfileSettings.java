package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.AdminPage;

public class AdminProfileSettings {

    public static Performable toAddNewUser() {
        return Task.where("{0} navigate to Add New User Page",
                Click.on(AdminPage.BTN_ADD_USER)
        );
    }

    public static Performable inputNameOfUser(String value) {
        return Task.where("{0} enter name: " + value,
                Actions.inputData(AdminPage.TXT_NAME, value)
        );
    }

    public static Performable inputEmailOfUser(String value) {
        return Task.where("{0} enter email: " + value,
                Actions.inputData(AdminPage.TXT_EMAIL, value)
        );
    }

    public static Performable inputUserNameOfUser(String value) {
        return Task.where("{0} enter username: " + value,
                Actions.inputData(AdminPage.TXT_USERNAME, value)
        );
    }

    public static Performable inputPasswordOfUser(String value) {
        return Task.where("{0} enter password: " + value,
                Actions.inputData(AdminPage.TXT_PASSWORD, value)
        );
    }

    public static Performable inputPhoneNumberOfUser(String value) {
        return Task.where("{0} enter phone number: " + value,
                Actions.inputData(AdminPage.TXT_PHONE_NUMBER, value)
        );
    }

    public static Performable chooseEmployeeRoleUser(String value) {
        return Task.where("{0} choose employee role: " + value,
                Actions.chooseOption(AdminPage.DRP_EMPLOYEE_ROLE, AdminPage.OPT_EMPLOYEE_ROLE, value)
        );
    }
}