package ui;

import net.serenitybdd.screenplay.targets.Target;
public class SignUpPage {
    public static final Target LBL_PARTNER_SIGN_UP = Target.the("Title Partner Sign up")
            .locatedBy("//h2[text()='PARTNER SIGN UP']");
    public static final Target LBL_PASSENGER_SIGN_UP = Target.the("Title Passenger Sign up")
            .locatedBy("//h2[text()='PASSENGER SIGN UP']");
    public static final Target TXT_NAME = Target.the("Textbox Name")
            .locatedBy("//input[@id='name']");
    public static final Target LBL_ERROR_NAME = Target.the("Error Name")
            .locatedBy("//strong[text()='Name is required']");
    public static final Target TXT_EMAIL = Target.the("Textbox Email")
            .locatedBy("//input[@id='email']");
    public static final Target LBL_ERROR_EMAIL = Target.the("Error Email")
            .locatedBy("//strong[text()='Email is required']");
    public static final Target TXT_PHONE_NUMBER = Target.the("Textbox Phone number")
            .locatedBy("//input[@id='phoneNumber']");
    public static final Target LBL_ERROR_PHONE_NUMBER = Target.the("Error Phone number")
            .locatedBy("//strong[text()='Phone number is required']");
    public static final Target TXT_USERNAME = Target.the("Textbox Username")
            .locatedBy("//input[@id='username']");
    public static final Target LBL_ERROR_USERNAME = Target.the("Error Username")
            .locatedBy("//strong[text()='Username is required']");
    public static final Target TXT_PASSWORD = Target.the("Textbox Password")
            .locatedBy("//input[@placeholder='Enter your password']");
    public static final Target LBL_ERROR_PASSWORD = Target.the("Error Password")
            .locatedBy("//strong[text()='Password is required']");
    public static final Target TXT_CONFIRM_PASSWORD = Target.the("Textbox Confirm Password")
            .locatedBy("//input[@placeholder='Confirm your password']");
    public static final Target LBL_ERROR_CONFIRM_PASSWORD = Target.the("Error Confirm Password")
            .locatedBy("//strong[text()='Confirm Password is required']");
}
