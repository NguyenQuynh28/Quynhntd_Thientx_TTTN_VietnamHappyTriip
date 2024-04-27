package tests.admin;

import model.DataTest;
import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.*;
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
                        DataTest.spaceCharacter,
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
                        DataTest.spaceCharacter,
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
                        DataTest.spaceCharacter,
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
                        DataTest.spaceCharacter,
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
                        DataTest.spaceCharacter,
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

    @Test
    @Tag("Admin_Test67")
    @Title("Test67: The system displays 'Embed Google Map Link is required'.")
    public void test67() {
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
                        DataTest.gMapLinkAndEmbed,
                        DataTest.spaceCharacter,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Embed Google Map Link")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Embed Google Map Link")).hasText("Embed google map link is required")
        );
    }

    @Test
    @Tag("Admin_Test68")
    @Title("Test68: The system displays 'Description is required'.")
    public void test68() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Description")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Description")).hasText("Description is required")
        );
    }

    @Test
    @Tag("Admin_Test69")
    @Title("Test69: The system displays 'Description is required'.")
    public void test69() {
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
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.spaceCharacter,
                        "HueIMG",
                        ".jpg"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Description")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Description")).hasText("Description is required")
        );
    }

    @Test
    @Tag("Admin_Test70")
    @Title("Test70: The system displays 'Image is required'.")
    public void test70() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Proceed to click 'Save'.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_SAVE_POI_STATIONS));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Image")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Image")).hasText("Image is required")
        );
    }

    @Test
    @Tag("Admin_Test71")
    @Title("Test71: The system displays 'Please choose the correct image format'")
    public void test71() {
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
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "Hue-Gif",
                        ".gif"
                )
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Image")).isDisplayed(),
                Ensure.that(AdminPage.ERROR_MESSAGE.of("Image")).hasText("Please choose the correct image format")
        );
    }

    @Test
    @Tag("Admin_Test72")
    @Title("Test72: The system successfully added the information and displayed the message 'Station is created successfully'")
    public void test72() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3. Fill in all the fields with the correct format information. 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                ),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(AdminPage.TOAST_MESSAGE).hasText("Station is created successfully")
        );
    }

    @Test
    @Tag("Admin_Test73")
    @Title("Test73: The system successfully added the information and displayed the message 'Station is created successfully'")
    public void test73() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3. Fill in all the fields with the correct format information. 4.Proceed to click 'Save'.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.addPoiAndStation(
                        "Hue Stations",
                        "Thừa Thiên Huế",
                        "Thừa Thiên Huế",
                        "Thành phố Huế",
                        DataTest.address,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.gMapLinkAndEmbed,
                        DataTest.description,
                        "HueIMG",
                        ".jpg"
                ),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(AdminPage.TOAST_MESSAGE).hasText("Station is created successfully")
        );
    }

    @Test
    @Tag("Admin_Test74")
    @Title("Test74: The 'Add New POI & Stations' page is not display.")
    public void test74() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations and 2.Click on the 'Add POI & Stations' button.
        when(admin).attemptsTo(AdminNavbarNavigate.toPoiAndStations());
        //3.Click on the "Cancel" button.
        andThat(admin).attemptsTo(Click.on(AdminPage.BTN_CANCEL_POI_STATIONS));
        //Check the system display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TITLE_POI_STATIONS).isNotDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test75")
    @Title("Test75: The 'Add New POI & Stations' page is not display.")
    public void test75() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations
        when(admin).attemptsTo(Click.on(AdminPage.NAV_BTN_POI_STATIONS));
        //3.Enter a non-existent station name.
        andThat(admin).attemptsTo(AdminPoiAndStations.searchPoiAndStations("Ho Chi Minh"));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.LBL_EMPTY_RESULT).isDisplayed(),
                Ensure.that(AdminPage.LBL_EMPTY_RESULT).hasText("No results found")
        );
    }

    @Test
    @Tag("Admin_Test76")
    @Title("Test76: The system displays information similar to the entered data.")
    public void test76() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //1.Navigate to Poi & Stations
        when(admin).attemptsTo(Click.on(AdminPage.NAV_BTN_POI_STATIONS));
        //3.Enter a station name that already exists in the system.
        andThat(admin).attemptsTo(AdminPoiAndStations.searchPoiAndStations("Quang Nam"));
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.OPTION_SEARCH_RESULT.of("Quang Nam")).isDisplayed()
        );
    }

    @Test
    @Tag("Admin_Test77")
    @Title("Test77: The system displays the message 'Station is updated successfully.'")
    public void test77() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Navigate to Poi & Stations and The admin performs the creation of POIs & Stations.
        when(admin).attemptsTo(
                AdminNavbarNavigate.toPoiAndStations()
                        .then(AdminPoiAndStations.addPoiAndStation()),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //2.Perform a click on any Stansport.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.searchAndSelectPoiAndStations("Hue Stations")
        );
        //3.Enter information into the field that needs to be edited and 4.Click on the "Save" button.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.updatePoiAndStations(AdminPage.TXT_NAME_POI_STATIONS, "Thua Thien Hue")
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.TOAST_MESSAGE).isDisplayed(),
                Ensure.that(AdminPage.TOAST_MESSAGE).hasText("Station is updated successfully")
        );
    }

    @Test
    @Tag("Admin_Test78")
    @Title("Test78: The 'POI & Station Details' window closes, and the user's information is no longer on the right list box of the screen.")
    public void test78() {
        //The system logged in successfully.
        givenThat(admin).attemptsTo(Login.toAdminPage());
        //Navigate to Poi & Stations and The admin performs the creation of POIs & Stations.
        when(admin).attemptsTo(
                AdminNavbarNavigate.toPoiAndStations()
                        .then(AdminPoiAndStations.addPoiAndStation()),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
        //2.Perform a click on any station. /3.Click on the "Remove" button.
        andThat(admin).attemptsTo(
                AdminPoiAndStations.removePoiAndStations("Hue Stations")
        );
        //Check the display.
        then(admin).attemptsTo(
                Ensure.that(AdminPage.OPTION_SEARCH_RESULT.of("Hue Stations")).isNotDisplayed()
        );
    }
}
