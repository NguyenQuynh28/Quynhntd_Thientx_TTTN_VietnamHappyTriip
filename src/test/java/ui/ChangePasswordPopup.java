package ui;

import net.serenitybdd.screenplay.targets.Target;

public class ChangePasswordPopup {
    public static final Target BTN_CHANGE_PASSWORD = Target.the("Button change password")
            .locatedBy("//p-button[@label='Change Password']");
    public static final Target POPUP_CHANGE_PASSWORD = Target.the("Popup change password")
            .locatedBy("//div[@role='dialog']//span[text()='Change Password']");
    public static final Target TXT_OLD_PASSWORD = Target.the("Textbox change password")
            .locatedBy("//input[@placeholder='Enter your old password']");
    public static final Target TXT_NEW_PASSWORD = Target.the("Textbox change password")
            .locatedBy("//input[@placeholder='Enter your new password']");
    public static final Target TXT_CONFIRM_PASSWORD = Target.the("Textbox change password")
            .locatedBy("//input[@placeholder='Enter confirm password']");
    public static final Target BTN_SAVE = Target.the("Buttom save change password")
            .locatedBy("//div[@role='dialog']//button[@type='submit']");
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .locatedBy("//label[text()='{0}']//parent::div//strong");
    public static final Target MESSAGE_ALERT = Target.the("Message")
            .locatedBy("//div[@data-pc-section='detail']");
}
