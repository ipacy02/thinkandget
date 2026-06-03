package navigation;

import Base.BaseTest;
import constants.Expected;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NavigationTest extends BaseTest {

    @Test
    public void testNavigation() {
        page.setViewportSize(1440, 900);

        LoginPage loginPage = new LoginPage(page);
        loginPage.login();
        HomePage homePage = new HomePage(page);
        homePage.clickShopLink();
        assertThat(page).hasURL(Expected.ShopLink);

        homePage.clickFeatureLink();
        assertThat(page).hasURL(Expected.Featurelink);

        homePage.clickFlashLink();
        assertThat(page).hasURL(Expected.FlashLink);
    }
}