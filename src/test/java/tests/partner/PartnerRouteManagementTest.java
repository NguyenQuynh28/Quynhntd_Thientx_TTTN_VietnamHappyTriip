package tests.partner;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
}
