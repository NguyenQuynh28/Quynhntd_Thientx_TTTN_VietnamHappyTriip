package tests;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Login;
import tasks.admin.AdminNavbarNavigate;
import ui.AdminPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@ExtendWith(SerenityJUnit5Extension.class)
public class AdminTest extends CommonTest {
    @Test
    @Tag("Test01")
    @Title("Test01: The Booking Confirmation is displayed")
    public void test01() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //1.Navigate to Booking Confirmation page
        when(admin).attemptsTo(AdminNavbarNavigate.toBookingConfirmation());

        then(admin).should(
                seeThat("The Booking Confirmation is displayed", the(AdminPage.TITLE_BOOKING_CONFIRMATION), isVisible())
        );
    }

    @Test
    @Tag("Test13")
    @Title("Test13: The title Add New User is displayed")
    public void test13() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminNavbarNavigate.toAddNewUser()
        );
        then(admin).should(
                seeThat("The title Add New User is displayed", the(AdminPage.TITLE_ADD_NEW_USER), isVisible())
        );
    }

    @Test
    @Tag("Test14")
    @Title("Test14: Error [Name is required] is displayed")
    public void test14() {
        //Logged in successfully to the login page
        givenThat(admin).attemptsTo(Login.toAdminPage());

        //Navigate to Add new User page and do not fill in the "Name" field
        when(admin).attemptsTo(
                AdminNavbarNavigate.toProfileSettings(),
                AdminNavbarNavigate.toAddNewUser()
        );
        then(admin).should(
                seeThat("The title Add New User is displayed", the(AdminPage.TITLE_ADD_NEW_USER), isVisible())
        );
    }
}

//"B1: Click vào button ""Profile & Settings"" tại thanh điều hướng bên trái màn hình.
//B2: Click vào button ""Add user"".
//B3: Tại trang ""Add user"", thực hiện nhập tất cả thông tin vào các trường (Trường ""Name"" để trống).
//B4: Thực hiện click ""Save""."

//Hệ thống hiển thị "Name is required".
