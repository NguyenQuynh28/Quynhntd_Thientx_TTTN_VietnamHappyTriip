package tests.partner;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Actions;
import tasks.Login;
import tasks.partner.PartnerNavbarNavigate;
import tests.CommonTest;
import ui.PartnerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PartnerRouteManagementTest")
public class PartnerRouteManagementTest extends CommonTest {
    @Test
    @Tag("Partner_Test112")
    @Title("Partner_Test112: Navigates to the “Add New Route” page")
    public void partner_test112() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add New Route page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement()
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TITLE_ADD_NEW_ROUTE).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test143")
    @Title("Partner_Test143: Display the Route to search for.")
    public void partner_test143() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Route Management page and search route
        when(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                Actions.inputData(PartnerPage.TXT_SEARCH, "Quang Nam")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.LBL_LIST_NEWS)).contains("Quang Nam")
        );
    }

    @Test
    @Tag("Partner_Test144")
    @Title("Partner_Test144: Message [No results found] is displayed")
    public void partner_test144() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Route Management page and search route
        when(client).attemptsTo(
                PartnerNavbarNavigate.toRouteManagement(),
                Actions.inputData(PartnerPage.TXT_SEARCH, "aaaaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.MESSAGE_SEARCH_NO_RESULTS).isDisplayed()
        );
    }
}
