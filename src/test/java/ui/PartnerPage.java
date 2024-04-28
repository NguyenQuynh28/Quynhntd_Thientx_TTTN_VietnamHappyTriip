package ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PartnerPage {

    public static final Target MESSAGE_SUCCESSFULLY = Target.the("Message successfully")
            .locatedBy("//div[@data-pc-section='detail']");
    public static final Target MESSAGE_DUPLICATE_ENTRY = Target.the("Message duplicate entry")
            .locatedBy("//div[@data-pc-section='detail']");
    public static final Target TXT_SEARCH = Target.the("Textbox search")
            .locatedBy("//input[contains(@placeholder,'Search')]");
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .locatedBy("//label[contains(text(),'{0}')]//parent::div//small");
    public static final Target TOAST_MESSAGE = Target.the("Toast message")
            .locatedBy("//div[contains(@class,'toast-message-text')]//div[contains(@class,'toast-detail')]");
    public static final Target BTN_CHOOSE_ROUTE_IN_LIST = Target.the("Button choose route in list")
            .locatedBy("//span[contains(text(),'{0}')]//parent::li");

    //Transport Management
    public static final Target NAV_BTN_TRANSPORT_MANAGEMENT = Target.the("Button navigate to transport management")
            .locatedBy("//div[@aria-label='Transport Management']");
    public static final Target TITLE_ADD_NEW_TRANSPORT = Target.the("Title Add New Transport")
            .locatedBy("//h4[text()='Add New Transport']");
    public static final Target TITLE_TRANSPORT_DETAILS = Target.the("Title Transport Details")
            .locatedBy("//h4[text()='Transport Details']");
    public static final Target TXT_NAME = Target.the("Text box name")
            .located(By.id("name"));
    public static final Target BTN_VEHICLE_TYPE = Target.the("Button vehicle type ")
            .locatedBy("//div[@role='button']");
    public static final Target LST_VEHICLE = Target.the("List box to select vehicle type ")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target BTN_SEAT_TYPE = Target.the("Button seat type")
            .locatedBy("//label[contains(text(),'Seat Type')]//ancestor::div[contains(@class,'Seat Type')]//button");
    public static final Target TXT_NORMAL_SEAT = Target.the("Text box input normal seat")
            .locatedBy("(//input[@placeholder='Name'])[1]");
    public static final Target TXT_NORMAL_SEAT_DESCRIPTION = Target.the("Text box input description of normal seat")
            .locatedBy("(//input[@placeholder='Description'])[1]");
    public static final Target TXT_NORMAL_SEAT_PRICE = Target.the("Text box input description of normal seat")
            .locatedBy("(//input[@placeholder='Price'])[1]");
    public static final Target TXT_VIP_SEAT = Target.the("Text box input VIP seat")
            .locatedBy("(//input[@placeholder='Name'])[2]");
    public static final Target TXT_VIP_SEAT_DESCRIPTION = Target.the("Text box input description of VIP seat")
            .locatedBy("(//input[@placeholder='Description'])[2]");
    public static final Target TXT_VIP_SEAT_PRICE = Target.the("Text box input price of VIP seat")
            .locatedBy("(//input[@placeholder='Price'])[2]");
    public static final Target BTN_NEXT = Target.the("Button navigate to Map Seat Information")
            .locatedBy("//p-button[@label='Next']");
    public static final Target TXT_ROW = Target.the("Text box row")
            .locatedBy("//label[@for='row']//ancestor::div[contains(@class,'row')]//input");
    public static final Target TXT_COL = Target.the("Text box col")
            .locatedBy("//label[text()='Col*']//ancestor::div[contains(@class,'col col-4')]//input");
    public static final Target BTN_CONFIRM = Target.the("Button confirm")
            .locatedBy("//p-button[@label='Confirm']");
    public static final Target BTN_VIP_SEAT_TYPE = Target.the("Button VIP Seat type")
            .locatedBy("//p-checkbox[@inputid='vip-seat-color']");
    public static final Target BTN_VIP_SEAT = Target.the("Button VIP Seat")
            .locatedBy("(//div[@class='matrix-row flex']//div[@class='p-checkbox p-component'])[1]");
    public static final Target BTN_COMPLETE = Target.the("Button complete")
            .locatedBy("//p-button[@label='Complete']");
    public static final Target BTN_IMPORT_IMAGE = Target.the("Button import image")
            .locatedBy("(//input[@accept='image/*'])[1]");
    public static final Target CHK_UTILITY = Target.the("Checkbox choose utility")
            .locatedBy("//label[text()='{0}']//ancestor::div[contains(@class,'field')]//p-checkbox");
    public static final Target LBL_TRANSPORT = Target.the("Label Transport")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target BTN_SAVE = Target.the("Button save to transport")
            .locatedBy("//p-button[@type='submit']");
    public static final Target LST_TRANSPORT = Target.the("List box transport")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target CHK_UTILITY_CHOSE = Target.the("Check box utility were chosen")
            .locatedBy("//div[contains(@class, 'input-container')]//div[contains(@class, 'p-highlight')]");
    public static final Target MESSAGE_ERROR_UTILITY = Target.the("Message error of utility")
            .locatedBy("//div[contains(@class,'utility')]//small//strong");

    //Partner Management
    public static final Target NAV_BTN_PARTNER_MANAGEMENT = Target.the("Button navigate to partner management")
            .locatedBy("//div[@aria-label='Partner Management']");
    public static final Target TITLE_PARTNER_PROFILE = Target.the("Title Partner profile")
            .locatedBy("//h4[text()='Partner profile']");
    public static final Target ERROR_PARTNER_ACCEPTED = Target.the("Error [Partner profile is in view mode because it was accepted!]")
            .locatedBy("//strong[text()=' Partner profile is in view mode because it was accepted! ']");
    public static final Target TXT_TAX_CODE = Target.the("Text box Tax Code")
            .located(By.id("taxCode"));
    public static final Target TXT_ADDRESS = Target.the("Text box address")
            .located(By.id("address"));
    public static final Target TXT_EMAIL = Target.the("Text box email")
            .located(By.id("email"));
    public static final Target TXT_PHONE_NUMBER = Target.the("Text box phone number")
            .located(By.id("phoneNumber"));
    public static final Target TXT_TITLE_PARTNER = Target.the("Text box title")
            .located(By.id("title"));
    public static final Target TXT_MEDIA_LINK = Target.the("Text box media link")
            .located(By.id("MedialLink"));
    public static final Target TXT_DESCRIPTION_PARTNER = Target.the("Text box description")
            .located(By.id("description"));
    public static final Target MESSAGE_ERROR = Target.the("Message error")
            .locatedBy("//div[contains(@class,'input-container')]//small//strong");
    public static final Target BTN_CANCEL_INFO_PARTNER = Target.the("Button cancel")
            .locatedBy("//p-button[@label='Cancel']");
    public static final Target TAKE_SCREENSHOT_PARTNER_PROFILE = Target.the("Take Screenshot partner profile")
            .locatedBy("//div[contains(@class,'px-6')]");
    public static final Target BTN_SAVE_PARTNER= Target.the("Text box title")
            .locatedBy("//button[@type='submit']");

    //Route Management
    public static final Target NAV_BTN_ROUTE_MANAGEMENT = Target.the("Button navigate to route management")
            .locatedBy("//div[@aria-label='Route Management']");
    public static final Target TITLE_ADD_NEW_ROUTE = Target.the("Title Add News")
            .locatedBy("//h4[text()='Add New Route']");
    public static final Target TXT_PRICE = Target.the("Text box price")
            .locatedBy("//input[@id='price']");
    public static final Target TXT_TIME = Target.the("Text box time")
            .locatedBy("//input[@id='{0}']");
    public static final Target TXT_DAYS = Target.the("Text box days")
            .locatedBy("//label[text()='Days*']//ancestor::div[contains(@class,'days')]//input");
    public static final Target CKL_LOCATION = Target.the("Choose location")
            .locatedBy("//div[contains(@class,'{0}')]//span[text()='From']");
    public static final Target LST_LIST = Target.the("Text box from list")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target CHK_CHOOSE_TRANSPORT = Target.the("Choose transport")
            .locatedBy("//label[@for='transport']//ancestor::div[contains(@class,'transport ')]//span");
    public static final Target CHK_CHOOSE_SCHEDULES = Target.the("Choose schedule")
            .locatedBy("//label[@for='route-schedules']//ancestor::div[contains(@class,'route-schedules')]");
    public static final Target CHK_CHOOSE_DAY = Target.the("Choose day")
            .locatedBy("//span[text()='{0}']");
    public static final Target TITLE_ROUTE_MANAGEMENT = Target.the("Title route management")
            .locatedBy("//h4[text()='Add New Route']");
    public static final Target BTN_ADD_NEW_PICKUP_POINT = Target.the("Button add new pickup point")
            .locatedBy("//span[text()='Add New Pickup Point']");
    public static final Target BTN_DELETE_PICKUP_POINT = Target.the("Button delete new pickup point")
            .locatedBy("//div[@formarrayname='pickUpPoints']//i");
    public static final Target TXT_PICKUP_POINT_ADDRESS = Target.the("Textbox pickup point address")
            .locatedBy("//input[contains(@placeholder,'Pickup point') and @formcontrolname]");
    public static final Target TXT_PICKUP_POINT_TIME = Target.the("Textbox pickup point time")
            .locatedBy("//input[contains(@placeholder,'Pickup point') and @id='time']");
    public static final Target ERROR_MESSAGE_PICKUP_AND_DROP_POINT = Target.the("Error message pickup and drop point")
            .locatedBy("//input[@formcontrolname='{0}' or @id='{0}']//ancestor::div[contains(@class,'gap-2')]//small");
    public static final Target BTN_ADD_NEW_DROP_POINT = Target.the("Button add new drop point")
            .locatedBy("//span[text()='Add New Drop Off Point']");
    public static final Target BTN_DELETE_DROP_POINT = Target.the("Button delete drop of point")
            .locatedBy("//div[@formarrayname='dropOffPoints']//i");
    public static final Target TXT_DROP_POINT_ADDRESS = Target.the("Textbox drop point address")
            .locatedBy("//input[contains(@placeholder,'Drop off point') and @formcontrolname]");
    public static final Target TXT_DROP_POINT_TIME = Target.the("Textbox drop point time")
            .locatedBy("//input[contains(@placeholder,'Drop off point') and @id='time']");
    public static final Target BTN_X = Target.the("Button X Province/City")
            .locatedBy("//label[contains(text(),'{0}')]//ancestor::div[contains(@class,'py-2')]//*[local-name()='svg' and contains(@class,'clear')]");

    //News Management
    public static final Target NAV_BTN_NEWS_MANAGEMENT = Target.the("Button navigate to news management")
            .locatedBy("//div[@aria-label='News Management']");
    public static final Target BTN_ADD_NEWS = Target.the("Button add news")
            .locatedBy("//p-button[@label='Add News']");
    public static final Target TITLE_ADD_NEWS = Target.the("Title Add News")
            .locatedBy("//h4[text()='Add News']");
    public static final Target TXT_TITLE = Target.the("Textbox title")
            .locatedBy("//input[@placeholder='Enter news title']");
    public static final Target TXT_DESCRIPTION = Target.the("Textbox description")
            .locatedBy("//div[@class='ql-editor ql-blank']");
    public static final Target TXT_DESCRIPTION_UPDATE = Target.the("Textbox description")
            .locatedBy("//div[@class='ql-editor']");
    public static final Target BTN_SAVE_NEWS = Target.the("Button save News")
            .locatedBy("//button[@type='submit']");
    public static final Target BTN_CANCEL_NEWS = Target.the("Button cancel News")
            .locatedBy("//span[text()='Cancel']");
    public static final Target ERROR_MESSAGE_NEWS = Target.the("Error message News")
            .locatedBy("//label[contains(text(),'{0}')]//parent::div//small");
    public static final Target LBL_NEWS = Target.the("Label News")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target MESSAGE_SEARCH_NO_RESULTS = Target.the("Message [No results found]")
            .locatedBy("//li[text()=' No results found ']");
    public static final Target LBL_LIST_NEWS = Target.the("Title News")
            .locatedBy("//ul[@class='p-listbox-list']//li//span");
    public static final Target BTN_REMOVE_NEWS = Target.the("Button remove News")
            .locatedBy("//span[text()='Remove']");
    public static final Target LBL_SLUG = Target.the("Label slug")
            .locatedBy("//label[text()='Slug']//ancestor::div[contains(@class,'title col-12')]");
}
