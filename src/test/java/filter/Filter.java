package filter;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;

import constants.ProductCategories;
import constants.ProductColors;
import constants.ProductPrices;
import constants.ProductSizes;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Filter extends BaseTest {

    private ShopPage shopPage;

    @BeforeClass
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
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectCategory(ProductCategories.BAGS_LUGGAGE);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
        assertThat(firstProductCard).containsText(ProductCategories.BAGS_LUGGAGE);

        shopPage.selectCategory(ProductCategories.BEAUTY_CARE);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
        assertThat(firstProductCard).containsText(ProductCategories.BEAUTY_CARE);
    }

    @Test(priority = 2)
    public void testSizeFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectSize(ProductSizes.SIZE_M);
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();

        assertThat(page).hasURL(java.util.regex.Pattern.compile("size=" + ProductSizes.SIZE_M));
    }

    @Test(priority = 3)
    public void testPriceRangePresetFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectPriceRangePreset(ProductPrices.RANGE_0_25);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertThat(firstProductCard).isVisible();
        assertThat(page).hasURL(java.util.regex.Pattern.compile("maxPrice=25"));
    }

    @Test(priority = 4)
    public void testColorFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectColor(ProductColors.WHITE_COLOR);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertThat(firstProductCard).isVisible();
        assertThat(page).hasURL(java.util.regex.Pattern.compile("color=" + ProductColors.WHITE_COLOR));
    }
}