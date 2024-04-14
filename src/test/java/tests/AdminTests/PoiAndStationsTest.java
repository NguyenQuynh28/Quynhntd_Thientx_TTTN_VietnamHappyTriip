package tests.AdminTests;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import tests.CommonTest;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class PoiAndStationsTest extends CommonTest {

    @Test
    @Tag("Admin_Test49")
    @Title("Test49: The system displays the page 'Add New POI & Stations.'")
    public void test49() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TITLE_POI_STATIONS).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test50")
    @Title("Test50: The system displays 'Name is required'.")
    public void test50() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Click on the 'Add POI & Stations' button.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_NAME.of("Name")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_NAME.of("Name")).hasText("Name is required")
        );
    }

    @Test
    @Tag("Admin_Test51")
    @Title("Test51: The system displays 'Name is required'.")
    public void test51() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Enter all information into the fields.
        andThat(admin).attemptsTo(
                Click.on(AdminPage.DRD_PROVINCE)
                        .then(Click.on(AdminPage.OPTION_PROVINCE.of("An Giang")))
        );
        //Check the display.
    }
}
