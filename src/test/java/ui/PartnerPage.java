package ui;

import net.serenitybdd.screenplay.targets.Target;

public class PartnerPage {
    public static final Target NAV_BTN_NAVIGATE = Target.the("Button navigate")
            .locatedBy("//div[@aria-label='{0}']");
    public static final Target TXT_NAME = Target.the("Text box name")
            .locatedBy("//input[@id='name']");
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
    public static final Target BTN_COMPLETE = Target.the("Button complete")
            .locatedBy("//p-button[@label='Complete']");
    public static final Target BTN_IMPORT_IMAGE = Target.the("Button import image")
            .locatedBy("(//input[@accept='image/*'])[1]");
    public static final Target BTN_UTILITY = Target.the("Button choose utility")
            .locatedBy("//label[text()='{0}']//ancestor::div[contains(@class,'field')]//p-checkbox");
    public static final Target BTN_SAVE = Target.the("Button save to transport")
            .locatedBy("//p-button[@type='submit']");
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
}
