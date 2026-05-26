package logout;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTests extends BaseTest {

    @Test
    public void testUserCanSignOut() {
        LoginPage loginPage = new LoginPage(page);
        LogoutPage logoutPage = new LogoutPage(page);

        loginPage.login();

        logoutPage.logout();

        assertThat(page.locator("a[href='/login']")).isVisible();

    }
}