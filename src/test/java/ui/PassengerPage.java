package ui;

import net.serenitybdd.screenplay.targets.Target;

public class PassengerPage {
    public static final Target MESSAGE_SUCCESS = Target.the("Message booking ticket is successful")
            .locatedBy("//div[@data-pc-section='detail']");

    //Booking History
    public static final Target DRP_CHOOSE_ADDRESS = Target.the("Dropdown choose address")
            .locatedBy("//p-dropdown[@placeholder='{0}']");
    public static final Target DRP_LIST_ADDRESS = Target.the("Dropdown list address")
            .locatedBy("//li[@aria-label='{0}']");
    public static final Target TXT_DEPART_DATE = Target.the("Tex box input depart date")
            .locatedBy("//p-calendar//input[@type='text']");
    public static final Target DRP_BORDER_FROM = Target.the("Border of from")
            .locatedBy("//div[contains(@class,'from flex flex')]//div[contains(@class,'p-dropdown-clearable')]");
    public static final Target DRP_BORDER_TO = Target.the("Border of to")
            .locatedBy("//div[contains(@class,'to flex flex')]//div[contains(@class,'p-dropdown-clearable')]");
    public static final Target TXT_BORDER_DEPART_DATE = Target.the("Border of depart date")
            .locatedBy("//div[@class='depart-date flex flex-column flex-1']//input");
    public static final Target BTN_CLEAR = Target.the("Button clear calendar")
            .locatedBy("//button[@type='button']//span[text()='Clear']");
    public static final Target BTN_SEARCH_TICKET = Target.the("Button search ticket")
            .locatedBy("//button[@class='p-ripple p-element p-button-secondary p-button p-component']");
    public static final Target BTN_BOOKING_NOW = Target.the("Button booking now")
            .locatedBy("//h4[text()='{0}']//ancestor::div[contains(@class,'card')]//p-button[@label='Book Now']");
    public static final Target BTN_CHOOSE_SEAT = Target.the("Button choose seat")
            .locatedBy("//div[text()='{0}']");
    public static final Target BTN_CHECKOUT = Target.the("Button checkout")
            .locatedBy("//button[@class='sc-cart-btn sc-cart-btn-submit']");
    public static final Target BTN_CASH = Target.the("Button cash")
            .locatedBy("//p-button[@label='Cash']");
    public static final Target BTN_CREDIT_AND_DEBIT_CARD = Target.the("Button credit and debit card")
            .locatedBy("//p-button[@label='Credit and debit card']");
    public static final Target MESSAGE_CHOOSE_PAYMENT_METHOD = Target.the("Message of popup Select payment method")
            .locatedBy("//div[@class='method-title m-lg-4']");
    public static final Target MESSAGE_PAYMENT_METHOD = Target.the("Message of popup Payment method")
            .locatedBy("//span[text()='Payment method']");
    public static final Target MESSAGE_YOUR_BOOKING = Target.the("Message your booking")
            .locatedBy("//h4[text()='Your Booking']");
    public static final Target MESSAGE_UTILITIES_VEHICLE = Target.the("Utilities On The Vehicle")
            .locatedBy("//h4[text()='Đà Nẵng - Hội An']//ancestor::div[@class='card flex flex-column w-full']//h4[text()='Utilities On The Vehicle']");
    public static final Target BTN_VIEW_DETAIL = Target.the("Button view detail")
            .locatedBy("//h4[text()='{0}']//ancestor::div[@class='card flex flex-column w-full']//span[text()='View Details']");
    public static final Target BTN_HIDE_DETAIL = Target.the("Button hide detail")
            .locatedBy("//h4[text()='{0}']//ancestor::div[@class='card flex flex-column w-full']//span[text()='Hide Details']");
    public static final Target MESSAGE_NO_TICKETS = Target.the("Message ticket is no ticket available")
            .locatedBy("//h4[text()='Sorry, there is no ticket available on this date']");
    public static final Target MESSAGE_RESULT = Target.the("Ticket search result message")
            .locatedBy("//h5[@class='ng-star-inserted']");
    public static final Target BTN_CUSTOM_USER = Target.the("Button custom user")
            .locatedBy("//button[@class='p-ripple p-element p-button-rounded p-button p-component']");
    public static final Target BTN_MANAGEMENT = Target.the("Button management")
            .locatedBy("//li[@aria-label='Management']");
    public static final Target TITLE_BOOKING_HISTORY = Target.the("Title booking history")
            .locatedBy("//div[@class='card surface-0 p-4']//h2");
    public static final Target NAV_BTN_BOOKING_HISTORY = Target.the("Navigate to booking history")
            .locatedBy("//div[@aria-label='Booking History']");
    public static final Target TXT_SEARCH_KEYWORD = Target.the("Text box search keyword")
            .locatedBy("//input[@placeholder='Search keyword']");
    public static final Target MESSAGE_NO_BOOKING_HISTORY = Target.the("Message oo booking histories found")
            .locatedBy("//td[@colspan='5']");
    public static final Target TXT_CODE = Target.the("Code of ticket is booked")
            .locatedBy("//td[text()=' {0} ']");
    public static final Target TXT_TAG = Target.the("Status of booking history")
            .locatedBy("//td[text()=' {0} ']//ancestor::tr//span[@class='p-tag-value']");
    public static final Target TXT_FIRST_TAG = Target.the("Status of booking history")
            .locatedBy("(//tr[contains(@class, 'p-selectable-row')])[1]//p-tag//span[@class='p-tag-value']");

    // Passenger Management
    public static final Target NAV_BTN_PASSENGER_MANAGEMENT = Target.the("Navigate to passenger management")
            .locatedBy("//div[@aria-label='Passenger Management']");
    public static final Target TITLE_PASSENGER_MANAGEMENT = Target.the("Title passenger management")
            .locatedBy("//div[@class='flex justify-content-between']//h4");
    public static final Target BTN_UPDATE = Target.the("Button update")
            .locatedBy("//p-button[@label='Update']");
    public static final Target TXT_NAME = Target.the("Text box name")
            .locatedBy("//input[@id='name']");
    public static final Target TXT_PHONE_NUMBER = Target.the("Text box phone number")
            .locatedBy("//input[@id='phoneNumber']");
    public static final Target BTN_SAVE = Target.the("Button save")
            .locatedBy("//p-button[@label='Save']");
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .locatedBy("//label[text()='{0}']//parent::div//strong");
    public static final Target TXT_EMAIL = Target.the("Text box email")
            .locatedBy("//input[@id='email']");
    public static final Target BTN_CANCEL = Target.the("Button cancel")
            .locatedBy("//p-button[@label='Cancel']");
    public static final Target LBL_ROUTE = Target.the("Label route")
            .locatedBy("//tr[contains(@class,'p-element')]");
}

