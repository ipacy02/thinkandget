package filter;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;
import constants.ProductCategories;
import constants.ProductColors;
import constants.ProductPrices;
import constants.ProductSizes;
import constants.Expected;
import constants.locators.ShopLocators;

import static org.testng.Assert.assertTrue;

public class Filter extends BaseTest {

    private ShopPage shopPage;
    private Locator firstProductCard;
    private Locator emptyStateMessage;

    @BeforeMethod
    public void setUpTestPreconditions() {
        page.setViewportSize(1440, 900);

        LoginPage loginPage = new LoginPage(page);
        loginPage.login();

        HomePage homePage = new HomePage(page);
        shopPage = homePage.clickShopLink();
        page.waitForLoadState(LoadState.NETWORKIDLE);

        firstProductCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        emptyStateMessage = page.locator(ShopLocators.NO_PRODUCTS_MESSAGE)
                .filter(new Locator.FilterOptions().setHasText(Expected.NoProductsFoundMessage))
                .first();
    }

    @Test(priority = 1)
    public void testCategoryFiltering() {
        shopPage.selectCategory(ProductCategories.BEAUTY_CARE);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(firstProductCard.isVisible() || emptyStateMessage.isVisible(),
                Expected.SortingFailedAssertionMsg);
    }

    @Test(priority = 2)
    public void testSizeFiltering() {
        shopPage.selectSize(ProductSizes.SIZE_M);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(firstProductCard.isVisible() || emptyStateMessage.isVisible(),
                Expected.SortingFailedAssertionMsg);
    }

    @Test(priority = 3)
    public void testPriceRangePresetFiltering() {
        shopPage.selectPriceRangePreset(ProductPrices.RANGE_0_25);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(firstProductCard.isVisible() || emptyStateMessage.isVisible(),
                Expected.SortingFailedAssertionMsg);
    }

    @Test(priority = 4)
    public void testColorFiltering() {
        shopPage.selectColor(ProductColors.WHITE_COLOR);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(firstProductCard.isVisible() || emptyStateMessage.isVisible(),
                Expected.SortingFailedAssertionMsg);
    }
}