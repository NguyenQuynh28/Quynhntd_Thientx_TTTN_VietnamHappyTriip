package tests;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.CastMember;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import tasks.Navigate;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

public class CommonTest {
    @Managed(driver = "chrome")
    protected WebDriver adminBrowser;

    @Managed(driver = "edge")
    protected WebDriver clientBrowser;

    @CastMember(name = "Admin")
    protected Actor admin;

    @CastMember(name = "Partner/Passenger")
    protected Actor client;

    @BeforeEach
    public void start() {
        givenThat(admin).can(BrowseTheWeb.with(adminBrowser));
        givenThat(client).can(BrowseTheWeb.with(clientBrowser));

        when(admin).attemptsTo(Navigate.toLoginAdminPage());
        when(client).attemptsTo(Navigate.toLoginClientPage());
    }

    @AfterEach
    public void close() {
        adminBrowser.close();
        clientBrowser.close();

    }
}
