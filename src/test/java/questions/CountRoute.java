package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import tasks.passenger.PassengerBookingHistory;
import ui.AdminPage;
import ui.PassengerPage;

public class CountRoute implements Question<Boolean> {
    private String codeOfTicket;
    private String value;
    public CountRoute(String codeOfTicket, String value){
        this.codeOfTicket = codeOfTicket;
        this.value = value;
    }
    public static CountRoute countRoute(String codeOfTicket, String value) {
        return new CountRoute(codeOfTicket, value);
    }

    @Override
    public Boolean answeredBy(Actor actor){
        int totalRouteCountBeforeClear = countTotalRoute(actor);

        actor.attemptsTo(
                PassengerBookingHistory.searchTicket(codeOfTicket),
                Click.on(PassengerPage.BTN_CLEAR)
        );

        int totalRouteCountAfterClear = countTotalRoute(actor);

        return totalRouteCountBeforeClear == totalRouteCountAfterClear;
    }

    private int countTotalRoute(Actor actor) {
        int totalRouteCount = 0;
        boolean hasNextPage = true;

        while (hasNextPage) {
            int routeCountOnPage = PassengerPage.LBL_ROUTE.resolveAllFor(actor).size();
            totalRouteCount = totalRouteCount + routeCountOnPage;

            if (Text.of(AdminPage.TXT_NUMBER_OF_PAGES).answeredBy(actor).contains(value)) {
                break;
            } else {
                actor.attemptsTo(
                        Click.on(AdminPage.BTN_CHANGE_PAGES)
                );
            }
        }
        return totalRouteCount;
    }
}
