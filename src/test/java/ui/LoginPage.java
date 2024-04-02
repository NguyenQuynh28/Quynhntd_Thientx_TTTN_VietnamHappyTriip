package ui;


import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class LoginPage {
    public static final Target BTN_CHOOSE_OPTION_LOGIN = Target.the("Button login in client page")
            .located(By.xpath("//li[@aria-label='Login']"));
    public static final Target BTN_OPTION_LOGIN = Target.the("Button option login in client page")
            .locatedBy("//a[contains(@href,'{0}') and (contains(@href,'login'))]");
    public static final Target TXT_USER_NAME = Target.the("TextBox user name").located(By.id("username"));
    public static final Target TXT_PASSWORD = Target.the("TextBox password").
            located(By.xpath("//input[@type='password']"));
    public static final Target BTN_LOGIN = Target.the("TextBox password")
            .located(By.xpath("//button[@type='submit']"));
}
