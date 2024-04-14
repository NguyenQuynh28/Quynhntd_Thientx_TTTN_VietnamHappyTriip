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
    public static final Target BTN_CONFIRM = Target.the("Button booking conformation")
            .locatedBy("//td[text()=' {0} ']//ancestor::tr//p-button[@label='Confirm']");
    public static final Target TXT_MESSAGE_BOOKING_CONFIRMATION= Target.the("Message displayed on popup")
            .locatedBy("//span[contains(@class,'confirm-dialog-message')]");
    public static final Target BTN_RECONFIRMATION_INFO= Target.the("Button reconfirm information")
            .locatedBy("//span[text()='{0}']");
    public static final Target LST_WAITING_LIST_CONFIRMATION = Target.the("List box waiting for confirmation")
            .locatedBy("//td[text()=' {0} ']//ancestor::tr]");

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
            .locatedBy("//li[@role='option']//div[text()='{0}']");
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

    //Partner Management
    public static final Target NAV_BTN_PARTNER_MANAGEMENT = Target.the("Button navigate to partner management")
            .locatedBy("//div[@aria-label='Partner Management']");

    //Route Management
    public static final Target NAV_BTN_ROUTE_MANAGEMENT = Target.the("Button navigate to route management")
            .locatedBy("//div[@aria-label='Route Management']");

    public static final Target BTN_PAGES = Target.the("Button pages")
            .locatedBy("//span[@class='p-paginator-pages ng-star-inserted']//button[text()=' {0} ']");
    public static final Target LBL_WAITING_CONFIRM_ROUTE = Target.the("Label wait route confirmation")
            .locatedBy(" //td[text()=' {0} ']//ancestor::tr");
    public static final Target TXT_ROUTE_DETAILS = Target.the("Message pending route details on popup")
            .locatedBy("(//div[contains(@class,'p-dialog-header')])[1]");
    public static final Target BTN_CONFIRM_ROUTE = Target.the("Button confirm route")
            .locatedBy("//p-button[@label='{0}']");
    public static final Target TXT_CONFIRM_INFORMATION = Target.the("Text confirm accept route")
            .locatedBy("//span[contains(@class,'p-confirm-popup-message')]");
    public static final Target BTN_RECONFIRM = Target.the("Button reconfirm information")
            .locatedBy("//button[@aria-label='{0}']");
    public static final Target LBL_ACCEPT = Target.the("Label accepted")
            .locatedBy("//td[text()=' {0} ']//ancestor::tr//span[text()='ACCEPTED']");
    public static final Target LBL_DENY = Target.the("Label denied")
            .locatedBy("//td[text()=' {0}  ']//ancestor::tr//span[text()='DENIED']");
    public static final Target MESSAGE_SEARCH_ROUTE = Target.the("Message [No results found]")
            .locatedBy("//td[text()='No routes found.']");
    public static final Target LBL_ROUTE_NAME = Target.the("Route name")
            .locatedBy("//td[text()=' {0} ']");
    public static final Target BTN_CLEAR = Target.the("Button clear information")
            .locatedBy("//p-button[@label='Clear']");
    public static final Target TXT_NUMBER_OF_PAGES= Target.the("Number of pages")
            .locatedBy("//span[@class='p-paginator-current ng-star-inserted']");

}
