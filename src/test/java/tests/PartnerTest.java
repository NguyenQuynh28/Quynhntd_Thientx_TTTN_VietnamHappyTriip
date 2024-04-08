package tests;

import net.serenitybdd.annotations.Title;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tasks.Actions;
import tasks.Login;
import tasks.partner.PartnerNavbarNavigate;
import tasks.partner.PartnerNewsManagement;
import ui.PartnerPage;

import static net.serenitybdd.screenplay.GivenWhenThen.*;

@ExtendWith(SerenityJUnit5Extension.class)
public class PartnerTest extends CommonTest {
    @Test
    @Tag("Partner_Test164")
    @Title("Partner_Test164: Navigates to the “Add News” page")
    public void partner_test164() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews()
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TILTLE_ADD_NEWS).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test165")
    @Title("Partner_Test165: Error [Title is required] is displayed")
    public void partner_test165() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and do not fill in the "Title" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Title"))).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test166")
    @Title("Partner_Test166: Error [Title is required] is displayed")
    public void partner_test166() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and the "Title" field is filled with space characters
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Title"))).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test167")
    @Title("Partner_Test167: Error [Title is invalid] is displayed")
    public void partner_test167() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and the "Title" field is >50 characters long
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Title"))).isEqualTo("Title is invalid")
        );
    }

    @Test
    @Tag("Partner_Test168")
    @Title("Partner_Test168: Message [ER_DUP_ENTRY] is displayed")
    public void partner_test168() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and the "Title" field matches an existing username
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("Quang Nam"),
                PartnerNewsManagement.inputDescription("Quang Nam"),
                PartnerNewsManagement.importImage("HoiAn", ".jpg"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_DUPLICATE_ENTRY)).isEqualTo("ER_DUP_ENTRY")
        );
    }

    @Test
    @Tag("Partner_Test170")
    @Title("Partner_Test170: Error [Description is required] is displayed")
    public void partner_test170() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and do not fill in the "Description" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Description"))).isEqualTo("Description is required")
        );
    }

    @Test
    @Tag("Partner_Test171")
    @Title("Partner_Test171: Error [Description is required] is displayed")
    public void partner_test171() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and the "Description" field is filled with space characters
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputDescription("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Description"))).isEqualTo("Description is required")
        );
    }

    @Test
    @Tag("Partner_Test172")
    @Title("Partner_Test172: Error [Please choose the correct image format] is displayed")
    public void partner_test172() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and import the incorrect image format
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("Happy"),
                PartnerNewsManagement.inputDescription("Happy"),
                PartnerNewsManagement.importImage("HoiAn", ".bmp"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Image"))).isEqualTo("Please choose the correct image format")
        );
    }

    @Test
    @Tag("Partner_Test173")
    @Title("Partner_Test173: Message [News is created successfully] is displayed")
    public void partner_test173() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and do not import image
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("Happy Triip"),
                PartnerNewsManagement.inputDescription("Happy Triip"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("News is created successfully")
        );
    }

    @Test
    @Tag("Partner_Test174")
    @Title("Partner_Test174: The [Add News] page is no longer displayed.")
    public void partner_test174() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and click button cancel
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("Happy Trip"),
                PartnerNewsManagement.inputDescription("Happy Trip"),
                PartnerNewsManagement.importImage("HoiAn", ".png"),
                Click.on(PartnerPage.BTN_CANCEL_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.TILTLE_ADD_NEWS).isNotDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test175")
    @Title("Partner_Test175: Message [News is created successfully] is displayed")
    public void partner_test175() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page and fill in all fields with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                PartnerNewsManagement.toAddNews(),
                PartnerNewsManagement.inputTitle("Vietnam Happy triip"),
                PartnerNewsManagement.inputDescription("Vietnam Happy triip"),
                PartnerNewsManagement.importImage("HoiAn", ".png"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("News is created successfully")
        );
    }

    @Test
    @Tag("Partner_Test176")
    @Title("Partner_Test176: Error [Title is required] is displayed")
    public void partner_test176() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and clear the "Title" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Quang Nam")),
                Clear.field(PartnerPage.TXT_TITLE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Title"))).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test177")
    @Title("Partner_Test177: Error [Title is required] is displayed")
    public void partner_test177() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and the "Title" field is filled with space characters
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Happy tripp")),
                PartnerNewsManagement.inputTitle("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Title"))).isEqualTo("Title is required")
        );
    }

    @Test
    @Tag("Partner_Test178")
    @Title("Partner_Test178: Error [Title is invalid] is displayed")
    public void partner_test178() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and the "Title" field is >50 characters long
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Happy tripp")),
                PartnerNewsManagement.inputTitle("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Title"))).isEqualTo("Title is invalid")
        );
    }

    @Test
    @Tag("Partner_Test179")
    @Title("Partner_Test179: Message [ER_DUP_ENTRY] is displayed")
    public void partner_test179() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and the "Title" field matches an existing username
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Happy tripp")),
                PartnerNewsManagement.inputTitle("Quang Nam"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_DUPLICATE_ENTRY)).isEqualTo("ER_DUP_ENTRY")
        );
    }

    @Test
    @Tag("Partner_Test180")
    @Title("Partner_Test180: Message [News is updated successfully] is displayed")
    public void partner_test180() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and update the "Title" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Trippp")),
                PartnerNewsManagement.inputTitle("Vietnam triip"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("News is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test181")
    @Title("Partner_Test181: Error [Description is required] is displayed")
    public void partner_test181() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and clear the "Description" field
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Quang Nam")),
                Clear.field(PartnerPage.TXT_DESCRIPTION_UPDATE)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Description"))).isEqualTo("Description is required")
        );
    }

    @Test
    @Tag("Partner_Test182")
    @Title("Partner_Test182: Error [Description is required] is displayed")
    public void partner_test182() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and the "Description" field is filled with space characters
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Happy tripp")),
                Clear.field(PartnerPage.TXT_DESCRIPTION_UPDATE),
                PartnerNewsManagement.inputDescription("          ")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.ERROR_MESSAGE_NEWS.of("Description"))).isEqualTo("Description is required")
        );
    }

    @Test
    @Tag("Partner_Test183")
    @Title("Partner_Test183: Message [News is updated successfully] is displayed")
    public void partner_test183() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to Add News page, click any News in the listbox and update the "Description" field with valid information
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Happy tripp")),
                Clear.field(PartnerPage.TXT_DESCRIPTION_UPDATE),
                PartnerNewsManagement.inputDescription("Vietnam triip"),
                Click.on(PartnerPage.BTN_SAVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("News is updated successfully")
        );
    }

    @Test
    @Tag("Partner_Test184")
    @Title("Partner_Test184: Display the title of News to search for.")
    public void partner_test184() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to News Management page and search user
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Actions.inputData(PartnerPage.TXT_SEARCH, "Quang Nam")
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.LBL_LIST_NEWS)).contains("Quang Nam")
        );
    }

    @Test
    @Tag("Partner_Test185")
    @Title("Partner_Test185: Message [No bookings found.] is displayed")
    public void partner_test185() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to News Management page and search user
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Actions.inputData(PartnerPage.TXT_SEARCH, "aaaaaaaaaa")
        );
        then(client).attemptsTo(
                Ensure.that(PartnerPage.MESSAGE_SEARCH_NEWS).isDisplayed()
        );
    }

    @Test
    @Tag("Partner_Test186")
    @Title("Partner_Test186: Message [News is delete successfully] is displayed")
    public void partner_test186() {
        //Logged in successfully to the partner page
        givenThat(client).attemptsTo(Login.toPartnerPage());

        //Navigate to News Management page, click any News in the listbox and delete News
        when(client).attemptsTo(
                PartnerNavbarNavigate.toNewsManagement(),
                Click.on(PartnerPage.LBL_NEWS.of("Vietnam Happy triip")),
                Click.on(PartnerPage.BTN_REMOVE_NEWS)
        );
        then(client).attemptsTo(
                Ensure.that(Text.of(PartnerPage.MESSAGE_SUCCESSFULLY)).isEqualTo("News is delete successfully")
        );
    }
}
