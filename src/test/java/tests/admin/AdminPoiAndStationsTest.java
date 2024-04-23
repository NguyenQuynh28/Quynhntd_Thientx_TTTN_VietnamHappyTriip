package tests.admin;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import tasks.admin.AdminPoiAndStations;
import tests.CommonTest;
import ui.AdminPage;
import untils.LoadConfig;

import java.nio.file.Path;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminPoiAndStationsTest extends CommonTest {

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
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Name")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Name")).hasText("Name is required")
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
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        DataTest.spaceChar,
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Name")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Name")).hasText("Name is required")
        );
    }

    @Test
    @Tag("Admin_Test52")
    @Title("Test52: The system displays 'Name is required'.")
    public void test52() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        DataTest.over50char,
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Name")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Name")).hasText("Name is invalid")
        );
    }

    @Test
    @Tag("Admin_Test53")
    @Title("Test53: The system displays 'Province/City is required'.")
    public void test53() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                Enter.theValue("Hue Stations").into(AdminPage.TXT_NAME_POI_STATIONS),
                Click.on(AdminPage.DRD_PROVINCE)
                        .then(JavaScriptClick.on(AdminPage.OPTION_PROVINCE.of("Thừa Thiên Huế"))),
                Enter.theValue("Thừa Thiên Huế").into(AdminPage.TXT_DISTRICT_POI_STATIONS),
                Enter.theValue("Thành phố Huế").into(AdminPage.TXT_WARD_POI_STATIONS),
                Enter.theValue(DataTest.address).into(AdminPage.TXT_ADDRESS_POI_STATIONS),
                Enter.theValue(DataTest.gMapLinkAndEmbed).into(AdminPage.TXT_GMAP_POI_STATIONS),
                Enter.theValue(DataTest.gMapLinkAndEmbed).into(AdminPage.TXT_EMBED_GMAP_POI_STATIONS),
                Enter.theValue(DataTest.description).into(AdminPage.TXT_DESCRIPTION_POI_STATIONS),
                Upload.theFile(Path.of(LoadConfig.getImagePath("HueIMG", ".jpg"))).to(AdminPage.BTN_UPLOAD_IMAGE),
                WaitUntil.the(AdminPage.BTN_X_PROVINCE, isVisible()),
                Click.on(AdminPage.BTN_X_PROVINCE),
                Click.on(AdminPage.BTN_SAVE_POI_STATIONS)
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Province/City")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Province/City")).hasText("Province/City is required")
        );
    }

    @Test
    @Tag("Admin_Test54")
    @Title("Test54: The system displays 'Province/City is required'.")
    public void test54() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Province/City")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Province/City")).hasText("Province/City is required")
        );
    }

    @Test
    @Tag("Admin_Test55")
    @Title("Test55: The system displays 'District is required'.")
    public void test55() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("District")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("District")).hasText("District is required")
        );
    }

    @Test
    @Tag("Admin_Test56")
    @Title("Test56: The system displays 'District is required'.")
    public void test56() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        DataTest.spaceChar,
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("District")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("District")).hasText("District is required")
        );
    }

    @Test
    @Tag("Admin_Test57")
    @Title("Test57: The system displays 'District is required'.")
    public void test57() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        DataTest.over50char,
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("District")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("District")).hasText("District is invalid")
        );
    }

    @Test
    @Tag("Admin_Test58")
    @Title("Test58: The system displays 'Ward is required'.")
    public void test58() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Ward")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Ward")).hasText("Ward is required")
        );
    }

    @Test
    @Tag("Admin_Test59")
    @Title("Test59: The system displays 'Ward is required'.")
    public void test59() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        DataTest.spaceChar,
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Ward")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Ward")).hasText("Ward is required")
        );
    }

    @Test
    @Tag("Admin_Test60")
    @Title("Test60: The system displays 'Ward is required'.")
    public void test60() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        DataTest.over50char,
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Ward")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Ward")).hasText("Ward is invalid")
        );
    }

    @Test
    @Tag("Admin_Test61")
    @Title("Test61: The system displays 'Address is required'.")
    public void test61() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Address")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Address")).hasText("Address is required")
        );
    }

    @Test
    @Tag("Admin_Test62")
    @Title("Test62: The system displays 'Address is required'.")
    public void test62() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.spaceChar,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Address")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Address")).hasText("Address is required")
        );
    }
    @Test
    @Tag("Admin_Test63")
    @Title("Test63: The system displays 'Address is required'.")
    public void test63() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.over100Char,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Address")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Address")).hasText("Address is invalid")
        );
    }

    @Test
    @Tag("Admin_Test64")
    @Title("Test64: The system displays 'Google Map Link is required'.")
    public void test64() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Google Map Link")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Google Map Link")).hasText("Google map link is required")
        );
    }

    @Test
    @Tag("Admin_Test65")
    @Title("Test65: The system displays 'Google Map Link is required'.")
    public void test65() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to enter all the information into the fields 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.spaceChar,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Google Map Link")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Google Map Link")).hasText("Google map link is required")
        );
    }

    @Test
    @Tag("Admin_Test66")
    @Title("Test66: The system displays 'Embed Google Map Link is required'.")
    public void test66() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Embed Google Map Link")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Embed Google Map Link")).hasText("Embed google map link is required")
        );
    }
}
