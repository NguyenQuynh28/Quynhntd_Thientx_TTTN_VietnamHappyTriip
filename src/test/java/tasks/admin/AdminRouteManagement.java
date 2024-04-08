package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.AdminPage;
import ui.PartnerPage;

public class AdminRouteManagement {
    public static Performable searchRoute(String value){
        return Task.where("Search route information", Actions.inputData(AdminPage.TXT_SEARCH, value));
    }
}
