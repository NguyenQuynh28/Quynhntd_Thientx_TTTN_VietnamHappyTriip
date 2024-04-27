package tasks.partner;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import tasks.Signup;
import tasks.SignupInfo;
import ui.SignupPage;

import java.util.Random;

public class SignupPartner implements Performable {
    private static String userName;
    private static String passWord;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        SignupPartner.userName = userName;
    }

    public static String getPassWord() {
        return passWord;
    }

    public static void setPassWord(String passWord) {
        SignupPartner.passWord = passWord;
    }

    public static SignupPartner signupSuccess() {
        return Tasks.instrumented(SignupPartner.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Random rand = new Random();
        int randomNumber = rand.nextInt(900) + 100;
        int randomPhoneNumber = rand.nextInt(900000000) + 100000000;
        String data = "Tester" + randomNumber;
        actor.attemptsTo(
                Signup.toSignupPartner(),
                SignupInfo.inputName("TesterPartner"),
                SignupInfo.inputEmail("TesterPartner@gmail.com"),
                SignupInfo.inputPhoneNumber(String.valueOf(randomPhoneNumber)),
                SignupInfo.inputUserName(data),
                SignupInfo.inputPassword(data),
                SignupInfo.inputConfirmPassword(data),
                Click.on(SignupPage.BTN_SIGNUP)
        );
        setUserName(data);
        setPassWord(data);
    }
}
