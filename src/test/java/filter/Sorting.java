package filter;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Sorting extends BaseTest {

    @Test
    public void testDropdownSortingOptions() {
        page.setViewportSize(1440, 900);

        LoginPage loginPage = new LoginPage(page);
        loginPage.login();

        HomePage homePage = new HomePage(page);
        ShopPage shopPage = homePage.clickShopLink();
        page.waitForLoadState(LoadState.NETWORKIDLE);

        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectSortOption("popular");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        shopPage.selectSortOption("price_asc");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        shopPage.selectSortOption("price_desc");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        shopPage.selectSortOption("rating");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
    }
}