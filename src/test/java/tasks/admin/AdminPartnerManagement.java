package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.AdminPage;

public class AdminPartnerManagement {
    public static Performable acceptPartner(){
        return Task.where("{0} accept partner",
                Click.on(AdminPage.BTN_ACCEPT)
        );
    }
    public static Performable noAcceptPartner(){
        return Task.where("{0} no accept partner",
               AdminPartnerManagement.acceptPartner()
                       .then(Click.on(AdminPage.BTN_NO))
        );
    }
    public static Performable yesAcceptPartner(){
        return Task.where("{0} yes accept partner",
               AdminPartnerManagement.acceptPartner()
                       .then(Click.on(AdminPage.BTN_YES))
        );
    }
    public static Performable denyPartner(){
        return Task.where("{0} accept partner",
                Click.on(AdminPage.BTN_DENY)
        );
    }
    public static Performable noDenyPartner(){
        return Task.where("{0} no accept partner",
                AdminPartnerManagement.denyPartner()
                        .then(Click.on(AdminPage.BTN_NO))
        );
    }
    public static Performable yesDenyPartner(){
        return Task.where("{0} yes accept partner",
                AdminPartnerManagement.denyPartner()
                        .then(Click.on(AdminPage.BTN_YES))
        );
    }
    public static Performable searchPartner(String name){
        return Task.where("{0} search partner",
                Click.on(AdminPage.TXT_SEARCH_PARTNER)
                        .then(Enter.theValue(name).into(AdminPage.TXT_SEARCH_PARTNER))
        );
    }
}
