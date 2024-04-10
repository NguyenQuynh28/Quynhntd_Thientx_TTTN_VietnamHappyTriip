package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class SignupPage {
    public static final Target BTN_CHOOSE_OPTION_SIGNUP = Target.the("Button signup client")
            .locatedBy("//li[@aria-label='Sign up']");
    public static final Target BTN_OPTION_SIGNUP = Target.the("Button option signup client")
            .locatedBy("//a[contains(@href,'{0}') and (contains(@href,'signup'))]");
    public static final Target TITLE_PARTNER_SIGN_UP = Target.the("Title Partner Sign up")
            .locatedBy("//h2[text()='PARTNER SIGN UP']");
    public static final Target TITLE_PASSENGER_SIGN_UP = Target.the("Title Passenger Sign up")
            .locatedBy("//h2[text()='PASSENGER SIGN UP']");
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .locatedBy("//label[text()='{0}']//parent::div//strong");
    public static final Target TXT_NAME = Target.the("Textbox name")
            .located(By.id("name"));
    public static final Target TXT_EMAIL = Target.the("Textbox email")
            .located(net.serenitybdd.core.annotations.findby.By.id("email"));
    public static final Target ERROR_EMAIL = Target.the("Error Email")
            .locatedBy("//strong[text()='Email is required']");
    public static final Target TXT_PHONE_NUMBER = Target.the("Textbox Phone number")
            .located(By.id("phoneNumber"));
    public static final Target ERROR_PHONE_NUMBER = Target.the("Error Phone number")
            .locatedBy("//strong[text()='Phone number is required']");
    public static final Target TXT_USERNAME = Target.the("Textbox Username")
            .located(By.id("username"));
    public static final Target ERROR_USERNAME = Target.the("Error Username")
            .locatedBy("//strong[text()='Username is required']");
    public static final Target TXT_PASSWORD = Target.the("Textbox Password")
            .locatedBy("//input[@placeholder='Enter your password']");
    public static final Target ERROR_PASSWORD = Target.the("Error Password")
            .locatedBy("//strong[text()='Password is required']");
    public static final Target TXT_CONFIRM_PASSWORD = Target.the("Textbox Confirm Password")
            .locatedBy("//input[@placeholder='Confirm your password']");
    public static final Target ERROR_CONFIRM_PASSWORD = Target.the("Error Confirm Password")
            .locatedBy("//strong[text()='Confirm Password is required']");
    public static final Target BTN_SIGNUP = Target.the("Button sign up")
            .locatedBy("//button[@type='submit']");
    public static final Target MESSAGE_DUPLICATE_ENTRY = Target.the("Message duplicate entry")
            .locatedBy("//div[@data-pc-section='detail']");
    public static final Target MESSAGE_ALERT = Target.the("Message")
            .locatedBy("//div[@data-pc-section='detail']");

}
