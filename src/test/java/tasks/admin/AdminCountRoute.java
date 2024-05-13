package tasks.admin;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import tasks.passenger.PassengerBookingHistory;
import ui.AdminPage;
import ui.PassengerPage;

public class AdminCountRoute implements Question<Boolean> {
    private String codeOfTicket;

    public AdminCountRoute(String codeOfTicket) {
        this.codeOfTicket = codeOfTicket;
    }

    public static AdminCountRoute countRoute(String codeOfTicket) {
        return new AdminCountRoute(codeOfTicket);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
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

            if (AdminPage.BTN_NEXT_IN_LIST.resolveFor(actor).isDisabled()) {
                break;
            } else {
                actor.attemptsTo(
                        Click.on(AdminPage.BTN_NEXT_IN_LIST)
                );
            }
        }
        return totalRouteCount;
    }
}
