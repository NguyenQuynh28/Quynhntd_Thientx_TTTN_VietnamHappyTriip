package ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class AdminPage {
    public static final Target TXT_SEARCH = Target.the("Textbox search")
            .locatedBy("//input[contains(@placeholder,'Search')]");
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .locatedBy("//label[text()='{0}']//parent::div//strong");


    //Booking Confirmation
    public static final Target NAV_BTN_BOOKING_CONFIRMATION = Target.the("Button navigate to booking confirmation")
            .locatedBy("//div[@aria-label='Booking Confirmation']");
    public static final Target TITLE_BOOKING_CONFIRMATION = Target.the("Title booking confirmation")
            .locatedBy("//div[@class='booking-confirmation']//h2");
    public static final Target BTN_CONFIRM_BOOKING = Target.the("Button booking confirmation")
            .locatedBy("(//p-button[@label='Confirm'])[1]");
    public static final Target BTN_CANCEL_BOOKING = Target.the("Button booking cancel")
            .locatedBy("(//p-button[@label='Cancel'])[1]");
    public static final Target BTN_RECONFIRM_BOOKING = Target.the("Button booking reconfirmation")
            .locatedBy("//button[contains(@class,'{0}')]");
    public static final Target TXT_MESSAGE_BOOKING_CONFIRMATION = Target.the("Message displayed on popup")
            .locatedBy("//span[contains(@class,'confirm-dialog-message')]");
    public static final Target LBL_NAME_PASSENGER = Target.the("Label name of passenger")
            .locatedBy("//span[text()='{0}']");
    public static final Target LBL_CODE = Target.the("Label code")
            .locatedBy("//td[text()=' {0} ']");
    public static final Target BTN_CONFIRM = Target.the("Button confirm")
            .locatedBy("(//p-button[@label='Confirm'])[1]");
    public static Target OPTION_BOOKING_IN_LIST(String name) {
        return Target.the("Option booking in list")
                .locatedBy("//span[contains(text(),'" + name + "')]//ancestor::tr//p-button[@label='Confirm']//ancestor::tr");
    }
    public static Target BTN_CONFIRM_BOOKING(String name) {
        return Target.the("Button confirm booking")
                .locatedBy("//span[contains(text(),'" + name + "')]//ancestor::tr//p-button[@label='Confirm']");
    }


    //Profile & Settings
    public static final Target NAV_BTN_PROFILE_SETTINGS = Target.the("Button navigate to profile & settings")
            .locatedBy("//div[@aria-label='Profile & Settings']");
    public static final Target BTN_ADD_USER = Target.the("Button add user")
            .locatedBy("//p-button[@label='Add User']");
    public static final Target TITLE_ADD_NEW_USER = Target.the("Title Add New User")
            .locatedBy("//h4[text()='Add New User']");
    public static final Target TXT_NAME = Target.the("Textbox name")
            .located(By.id("name"));
    public static final Target ERROR_NAME = Target.the("Error name")
            .locatedBy("//strong[text()='Name is required']");
    public static final Target TXT_EMAIL = Target.the("Textbox email")
            .located(By.id("email"));
    public static final Target ERROR_EMAIL = Target.the("Error email")
            .locatedBy("//strong[text()='Email is required']");
    public static final Target TXT_USERNAME = Target.the("Textbox username")
            .located(By.id("username"));
    public static final Target ERROR_USERNAME = Target.the("Error username")
            .locatedBy("//strong[text()='Username is required']");
    public static final Target TXT_PASSWORD = Target.the("Textbox password")
            .locatedBy("//input[@placeholder='Enter your password']");
    public static final Target ERROR_PASSWORD = Target.the("Error password")
            .locatedBy("//strong[text()='Password is required']");
    public static final Target TXT_PHONE_NUMBER = Target.the("Textbox phone number")
            .located(By.id("phoneNumber"));
    public static final Target ERROR_PHONE_NUMBER = Target.the("Error phone number")
            .locatedBy("//strong[text()='Phone number is required']");
    public static final Target DRP_EMPLOYEE_ROLE = Target.the("Dropdown employee role")
            .locatedBy("//div[@aria-label='dropdown trigger']");
    public static final Target ERROR_EMPLOYEE_ROLE = Target.the("Error employee role")
            .locatedBy("//strong[text()='Employee role is required']");
    public static final Target OPT_EMPLOYEE_ROLE = Target.the("Option employee role")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target BTN_SAVE_USER = Target.the("Button save new user")
            .locatedBy("//button[@type='submit']");
    public static final Target BTN_CANCEL_NEW_USER = Target.the("Button cancel new user")
            .locatedBy("//span[text()='Cancel']");
    public static final Target MESSAGE_DUPLICATE_ENTRY = Target.the("Message duplicate entry")
            .locatedBy("//div[@data-pc-section='detail']");
    public static final Target MESSAGE_SUCCESSFULLY = Target.the("Message successfully")
            .locatedBy("//div[@data-pc-section='detail']");
    public static final Target MESSAGE_SEARCH_USER = Target.the("Message [No results found]")
            .locatedBy("//li[text()=' No results found ']");
    public static final Target LBL_LIST_USER = Target.the("Name user")
            .locatedBy("//ul[@class='p-listbox-list']//li//span");
    public static final Target LBL_USER = Target.the("Label user")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target BTN_REMOVE_USER = Target.the("Button remove user")
            .locatedBy("//span[text()='Remove']");

    //Sales report
    public static final Target NAV_BTN_SALES_REPORT = Target.the("Button navigate to sales report")
            .locatedBy("//div[@aria-label='Sales Report']");
    public static final Target BTN_TAB_OF_MONTH = Target.the("Button tab revenue of month")
            .locatedBy("//span[text()='Revenue of month']");
    public static final Target BTN_TAB_OF_YEAR = Target.the("Button tab revenue of year")
            .locatedBy("//span[text()='Revenue of year']");
    public static final Target BTN_CHOOSE_TIME = Target.the("Button choose time")
            .locatedBy("//p-calendar[@view='{0}']");
    public static final Target LTB_CHOOSE_TIME = Target.the("Lable choose time")
            .locatedBy("//span[text()=' {0} ']");
    public static final Target TABLE_REVENUE = Target.the("Table revenue")
            .locatedBy("//p-tabpanel[@header='{0}']");

    //POI & Station
    public static final Target NAV_BTN_POI_STATIONS = Target.the("Button navigate to POI & stations")
            .locatedBy("//div[@aria-label='POI & Stations']");
    public static final Target BTN_ADD_POI_STATIONS = Target.the("Button add POI & stations")
            .locatedBy("//button//span[text()='Add POI & Station']");
    public static final Target TITLE_POI_STATIONS = Target.the("Title POI & stations")
            .locatedBy("//div[@class='poi-stations']//h4");
    public static final Target BTN_SAVE_POI_STATIONS = Target.the("Button POI & stations")
            .locatedBy("//button//span[text()='Save']");
    public static final Target TXT_NAME_POI_STATIONS = Target.the("Textbox name POI & stations")
            .located(By.id("name"));
    public static final Target DRD_PROVINCE = Target.the("Option Province/City")
            .locatedBy("//label[@for='city']//parent::div//span");
    public static final Target OPTION_PROVINCE = Target.the("Option Province/City")
            .locatedBy("//ul[@role='listbox']//div[text()='{0}']");
    public static final Target BTN_X_PROVINCE = Target.the("Button X Province/City")
            .locatedBy("//timesicon//*[local-name()='svg']");
    public static final Target TXT_DISTRICT_POI_STATIONS = Target.the("Textbox district POI & stations")
            .located(By.id("district"));
    public static final Target TXT_WARD_POI_STATIONS = Target.the("Textbox ward POI & stations")
            .located(By.id("ward"));
    public static final Target TXT_ADDRESS_POI_STATIONS = Target.the("Textbox address POI & stations")
            .located(By.id("address"));
    public static final Target TXT_GMAP_POI_STATIONS = Target.the("Textbox google map POI & stations")
            .located(By.id("gmapLink"));
    public static final Target TXT_EMBED_GMAP_POI_STATIONS = Target.the("Textbox embed google map POI & stations")
            .located(By.id("embedGmapLink"));
    public static final Target TXT_DESCRIPTION_POI_STATIONS = Target.the("Textbox description map POI & stations")
            .located(By.id("description"));
    public static final Target BTN_UPLOAD_IMAGE = Target.the("Button upload image")
            .located(By.xpath("//input[@accept='image/*'][1]"));
    public static final Target IMAGE_UPLOAD_SUCCESS = Target.the("Image upload success")
            .locatedBy("//div[@class='image']//img[not(contains(@src,'dummy'))]");
    public static final Target TOAST_MESSAGE = Target.the("Toast message")
            .locatedBy("//div[contains(@class,'toast-message-text')]//div[contains(@class,'toast-detail')]");
    public static final Target BTN_CANCEL_POI_STATIONS = Target.the("Button cancel Poi & Stations")
            .locatedBy("//p-button[@label='Cancel']");
    public static final Target TXT_SEARCH_POI_STATIONS = Target.the("Textbox search Poi & Stations")
            .locatedBy("//input[@placeholder='Search POI & Station']");
    public static final Target LBL_EMPTY_RESULT = Target.the("Label empty result")
            .locatedBy("//li[contains(@class,'empty-message')]");
    public static final Target OPTION_SEARCH_RESULT = Target.the("Option search result")
            .locatedBy("//ul[@role='listbox']//span[contains(text(),'{0}')][1]");
    public static final Target BTN_REMOVE_POI_STATIONS = Target.the("Button remove Poi & Stations")
            .locatedBy("//span[text()='Remove']");

    //Partner Management
    public static final Target NAV_BTN_PARTNER_MANAGEMENT = Target.the("Button navigate to partner management")
            .locatedBy("//div[@aria-label='Partner Management']");

    public static Target OPTION_PARTNER_IN_LIST(String status, String name) {
        return Target.the("Option partner in list")
                .locatedBy("//span[text()='" + status + "']//ancestor::tr//td[contains(text(),'" + name + "')]");
    }

    public static Target POPUP_PARTNER_DETAIL = Target.the("Popup partner detail")
            .locatedBy("//span[text()='Partner details']//ancestor::div[@role='dialog']");
    public static Target BTN_NEXT_IN_LIST = Target.the("Button next in list")
            .locatedBy("//button[contains(@class,'paginator-next')]");
    public static Target BTN_ACCEPT = Target.the("Button accept")
            .locatedBy("//button//span[text()='Accept']");
    public static Target BTN_DENY = Target.the("Button deny")
            .locatedBy("//button//span[text()='Deny']");
    public static Target ALERT_CONFIRM = Target.the("Alert accept")
            .locatedBy("//div[@role='alertdialog']//span[contains(@class,'confirm-popup-message')]");
    public static Target BTN_YES = Target.the("Button yes in alert")
            .locatedBy("//div[@role='alertdialog']//button[@aria-label='Yes']");
    public static Target BTN_NO = Target.the("Button no in alert")
            .locatedBy("//div[@role='alertdialog']//button[@aria-label='No']");
    public static Target TITLE_PARTNER_MANAGEMENT = Target.the("Title partner management page")
            .locatedBy("//h2[text()='Partner Management']");
    public static Target TXT_SEARCH_PARTNER = Target.the("Textbox search partner")
            .locatedBy("//input[@placeholder='Search keyword']");
    public static Target LBL_NO_PARTNER_FOUND = Target.the("Label no partner found")
            .locatedBy("//td[text()='No partners found.']");
    public static Target PARTNER_SEARCH_RESULT = Target.the("Partner search result")
            .locatedBy("//td[contains(text(),'{0}')]//parent::tr");
    public static Target BTN_CLEAR_SEARCH = Target.the("Button clear search")
            .locatedBy("//span[text()='Clear']");
    public static Target LIST_PARTNER_MANAGEMENT = Target.the("List partner management")
            .locatedBy("//table[@role='table']");

    //Route Management
    public static final Target NAV_BTN_ROUTE_MANAGEMENT = Target.the("Button navigate to route management")
            .locatedBy("//div[@aria-label='Route Management']");
    public static final Target BTN_CHANGE_PAGES = Target.the("Button change pages")
            .locatedBy("//button[contains(@class,'p-paginator-next')]");
    public static final Target TXT_ROUTE_DETAILS = Target.the("Message pending route details on popup")
            .locatedBy("(//div[contains(@class,'p-dialog-header')])[1]");
    public static final Target BTN_CONFIRM_ROUTE = Target.the("Button confirm route")
            .locatedBy("//p-button[@label='{0}']");
    public static final Target TXT_CONFIRM_INFORMATION = Target.the("Text confirm accept route")
            .locatedBy("//span[contains(@class,'p-confirm-popup-message')]");
    public static final Target MESSAGE_NO_RESULTS = Target.the("Message [No results found]")
            .locatedBy("//tr[@class='ng-star-inserted']//td");
    public static final Target LBL_ROUTE_NAME = Target.the("Route name")
            .locatedBy("//td[text()=' {0} ']");
    public static final Target TXT_NUMBER_OF_PAGES = Target.the("Number of pages")
            .locatedBy("//span[@class='p-paginator-current ng-star-inserted']");
    public static final Target BTN_RECONFIRM = Target.the("Button reconfirm information")
            .locatedBy("//button[@aria-label='{0}']");

    public static Target LBL_ROUTE(String status, String route) {
        return Target.the("Label route")
                .locatedBy(String.format("//span[text()='" + status + "']//ancestor::tr//td[text()=' " + route + " ']"));
    }

    public static Target OPTION_ROUTE_IN_LIST(String status, String name) {
        return Target.the("Option route in list")
                .locatedBy("//td[contains(text(),'" + name + "')]//ancestor::tr//span[contains(text(),'" + status + "')]");
    }
}
