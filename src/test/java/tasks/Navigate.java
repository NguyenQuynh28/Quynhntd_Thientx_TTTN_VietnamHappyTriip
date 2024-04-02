package tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import untils.LoadConfig;

public class Navigate {
    public static Performable toLoginAdminPage() {
        return Task.where("{0} navigate to admin page",
                Open.url(LoadConfig.getURLAdmin())
        );
    }

    public static Performable toLoginClientPage() {
        return Task.where("{0} navigate to client page",
                Open.url(LoadConfig.getURLClient())
        );
    }
}
