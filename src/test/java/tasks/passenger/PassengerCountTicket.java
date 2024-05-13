package tasks.passenger;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import ui.AdminPage;
import ui.PassengerPage;

public class PassengerCountTicket implements Question<Boolean> {
    public static PassengerCountTicket countTicket() {
        return new PassengerCountTicket();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        //Check the page changes or not
        boolean hasNextPage = true;
        while (hasNextPage) {
            if (PassengerPage.BTN_PAGES_NUMBER.resolveFor(actor).isDisplayed()) {
                String pageBefore = PassengerPage.BTN_PAGES_NUMBER.resolveFor(actor).getText();
                actor.attemptsTo(
                        Click.on(AdminPage.BTN_NEXT_IN_LIST)
                );
                String pageAfter = PassengerPage.BTN_PAGES_NUMBER.resolveFor(actor).getText();
                actor.attemptsTo(
                        Click.on(AdminPage.BTN_NEXT_IN_LIST)
                );
                String pageFinal = PassengerPage.BTN_PAGES_NUMBER.resolveFor(actor).getText();
                if (pageBefore.equals(pageAfter) && pageAfter.equals(pageFinal)) {
                    break;
                } else {
                    Click.on(AdminPage.BTN_NEXT_IN_LIST);
                }

            } else {
                hasNextPage = false;
            }
        }

        // Get the 2nd and last number in the "Showing 0 to 0 of 0 entries" paragraph

        // Get text "Showing 0 to 0 of 0 entries"
        String text = PassengerPage.TXT_PAGES.resolveFor(actor).getText();

        // [\s+]: tat ca cac ky tu khong phai so se dc thay the bang khoang trang ( 51  90  107 ); [split(" ")] : tach chuoi vua roi thanh cac chuoi con (" " "51" " " "90" " " "107" " ")
        String[] numbers = text.replaceAll("\\s+", " ").split(" ");

        // Lay ky tu o so chi muc 3 tinh tu 0 và chuyen String thanh int
        int secondNumber = Integer.parseInt(numbers[3]);

        // Lay ky tu o so chi muc 5 tinh tu 0 và chuyen String thanh int
        int lastNumber = Integer.parseInt(numbers[5]);

        return secondNumber == lastNumber;
    }
}


