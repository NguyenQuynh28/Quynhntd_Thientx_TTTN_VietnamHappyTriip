package tests.passenger;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tests.CommonTest;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

@ExtendWith(SerenityJUnit5Extension.class)
@Tag("PassengerChangePasswordTest")
public class PassengerChangePasswordTest extends CommonTest {
    @Test
    @Tag("Passenger_Test65")
    @Title("Passenger_Test65: Popup [Change Password] is displayed")
    public void passenger_test65() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test66")
    @Title("Passenger_Test66: Error [Old Password is required] is displayed")
    public void passenger_test66() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test67")
    @Title("Passenger_Test67: Message [Wrong password] is displayed")
    public void passenger_test67() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test68")
    @Title("Passenger_Test68: Error [New Password is required] is displayed")
    public void passenger_test68() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test69")
    @Title("Passenger_Test69: Error [New Password is required] is displayed")
    public void partner_test69() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test70")
    @Title("Passenger_Test70: Error [New Password is invalid] is displayed")
    public void passenger_test70() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test71")
    @Title("Passenger_Test71: Error [New Password is invalid] is displayed")
    public void passenger_test71() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test72")
    @Title("Passenger_Test72: Error [New Password is invalid] is displayed")
    public void passenger_test72() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test73")
    @Title("Passenger_Test73: Error [New Password is invalid] is displayed")
    public void passenger_test73() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test74")
    @Title("Passenger_Test74: Error [New Password is invalid] is displayed")
    public void passenger_test74() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test75")
    @Title("Passenger_Test75: Error [New Password is invalid] is displayed")
    public void passenger_test75() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test76")
    @Title("Passenger_Test76: Message [Duplicate entry] is displayed")
    public void passenger_test76() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test77")
    @Title("Passenger_Test77: Error [Confirm Password is required] is displayed")
    public void passenger_test77() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test78")
    @Title("Passenger_Test78: Message [Password do not match] is displayed")
    public void passenger_test78() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }

    @Test
    @Tag("Passenger_Test79")
    @Title("Passenger_Test79: Message [Password updated successfully!] is displayed")
    public void passenger_test79() {
        //Logged in successfully to the passenger page
        givenThat(client).attemptsTo(Login.toPassengerPage());

        //Navigate to Passenger Management page and change password

    }
}
