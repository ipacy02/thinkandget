package filter;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeMethod; // Use BeforeMethod to reset state every time
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;
import constants.ProductCategories;
import constants.ProductColors;
import constants.ProductPrices;
import constants.ProductSizes;
import constants.ShopLocators;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Filter extends BaseTest {

    private ShopPage shopPage;

    @BeforeMethod // This will run before EACH test, giving you a fresh page session
    public void setUpTestPreconditions() {
        page.setViewportSize(1440, 900);

        LoginPage loginPage = new LoginPage(page);
        loginPage.login();

        HomePage homePage = new HomePage(page);
        shopPage = homePage.clickShopLink();
        page.waitForLoadState(LoadState.NETWORKIDLE);
    }

    @Test(priority = 1)
    public void testCategoryFiltering() {
        Locator firstProductCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        shopPage.selectCategory(ProductCategories.BAGS_LUGGAGE);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
    }

    @Test(priority = 2)
    public void testSizeFiltering() {
        Locator firstProductCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        shopPage.selectSize(ProductSizes.SIZE_M);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
    }

    @Test(priority = 3)
    public void testPriceRangePresetFiltering() {
        Locator firstProductCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        shopPage.selectPriceRangePreset(ProductPrices.RANGE_0_25);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
    }

    @Test(priority = 4)
    public void testColorFiltering() {
        Locator firstProductCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        shopPage.selectColor(ProductColors.WHITE_COLOR);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
    }
}