package tasks.partner;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Actions;
import ui.PartnerPage;

public class PartnerNewsManagement {

    public static Performable toAddNews() {
        return Task.where("{0} navigate to Add News Page",
                Click.on(PartnerPage.BTN_ADD_NEWS)
        );
    }

    public static Performable inputTitle(String value) {
        return Task.where("{0} enter title: " + value,
                Actions.inputData(PartnerPage.TXT_TITLE, value)
        );
    }

    public static Performable inputDescription(String value) {
        return Task.where("{0} enter description: " + value,
                Actions.inputData(PartnerPage.TXT_DESCRIPTION, value)
        );
    }

    public static Performable importImage(String value, String type) {
        return Task.where("{0} import image: ",
                Actions.upLoadIMG(PartnerPage.BTN_IMPORT_IMAGE, value, type)
        );

    }
}