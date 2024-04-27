package tasks.admin;

import model.DataTest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ui.AdminPage;
import untils.LoadConfig;
import java.nio.file.Path;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AdminPoiAndStations {
    public static Performable addPoiAndStation(String name, String city, String district, String ward,
                                               String address, String gMapLink, String embedGMapLink, String description, String valueIMG, String typeIMG) {
        return Task.where("{0} add poi and stations with information",
                Enter.theValue(name).into(AdminPage.TXT_NAME_POI_STATIONS),
                Click.on(AdminPage.DRD_PROVINCE)
                        .then(JavaScriptClick.on(AdminPage.OPTION_PROVINCE.of(city))),
                Enter.theValue(district).into(AdminPage.TXT_DISTRICT_POI_STATIONS),
                Enter.theValue(ward).into(AdminPage.TXT_WARD_POI_STATIONS),
                Enter.theValue(address).into(AdminPage.TXT_ADDRESS_POI_STATIONS),
                Enter.theValue(gMapLink).into(AdminPage.TXT_GMAP_POI_STATIONS),
                Enter.theValue(embedGMapLink).into(AdminPage.TXT_EMBED_GMAP_POI_STATIONS),
                Enter.theValue(description).into(AdminPage.TXT_DESCRIPTION_POI_STATIONS),
                Upload.theFile(Path.of(LoadConfig.getImagePath(valueIMG, typeIMG))).to(AdminPage.BTN_UPLOAD_IMAGE),
                Click.on(AdminPage.BTN_SAVE_POI_STATIONS)
        );
    }

    public static Performable addPoiAndStation() {
        return Task.where("{0} add poi and stations with information",
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
                Click.on(AdminPage.BTN_SAVE_POI_STATIONS)
        );
    }

    public static Performable searchPoiAndStations(String name) {
        return Task.where("{0} search Poi & Stations",
                Click.on(AdminPage.TXT_SEARCH_POI_STATIONS)
                        .then(Enter.theValue(name).into(AdminPage.TXT_SEARCH_POI_STATIONS))
        );
    }

    public static Performable searchAndSelectPoiAndStations(String name) {
        return Task.where("{0} search and select poi and stations",
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isNotVisible()).forNoMoreThan(120).seconds(),
                AdminPoiAndStations.searchPoiAndStations(name)
                        .then(JavaScriptClick.on(AdminPage.OPTION_SEARCH_RESULT.of(name)))
        );
    }

    public static Performable updatePoiAndStations(Target target, String value) {
        return Task.where("{0} search and select poi and stations",
                Click.on(target).
                        then(Enter.theValue(value).into(target))
                        .then(Click.on(AdminPage.BTN_SAVE_POI_STATIONS)),
                WaitUntil.the(AdminPage.TOAST_MESSAGE, isVisible()).forNoMoreThan(120).seconds()
        );
    }

    public static Performable removePoiAndStations(String name) {
        return Task.where("{0} remove Poi & Stations",
                AdminPoiAndStations.searchAndSelectPoiAndStations(name),
                Click.on(AdminPage.BTN_REMOVE_POI_STATIONS)
                        .then(Clear.field(AdminPage.TXT_SEARCH_POI_STATIONS))
        );
    }
}
