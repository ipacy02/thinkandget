package filter;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeClass; // Switched to BeforeClass for optimization
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;

import constants.ProductSorting;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Sorting extends BaseTest {

    private ShopPage shopPage;

    @BeforeMethod
    public void setUpTestPreconditions() {
        page.setViewportSize(1440, 900);

        LoginPage loginPage = new LoginPage(page);
        loginPage.login();

        HomePage homePage = new HomePage(page);
        shopPage = homePage.clickShopLink();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    @Test
    public void testDropdownSortingOptions() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectSortOption(ProductSorting.POPULAR);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        shopPage.selectSortOption(ProductSorting.PRICE_LOW_HIGH);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        shopPage.selectSortOption(ProductSorting.PRICE_HIGH_LOW);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        shopPage.selectSortOption(ProductSorting.TOP_RATED);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
    }
}