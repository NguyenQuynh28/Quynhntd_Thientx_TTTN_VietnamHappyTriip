package tasks.admin;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Upload;
import ui.AdminPage;
import untils.LoadConfig;

import java.nio.file.Path;


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
}
