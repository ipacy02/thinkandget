package filter;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import constants.ProductColors;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Filter extends BaseTest {

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

    // --- TEST 1: FILTER BY CATEGORY ---
    @Test
    public void testCategoryFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        // Filter by Bags & Luggage
        shopPage.selectCategory("Bags & Luggage");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
        assertThat(firstProductCard).containsText("Bags & Luggage");

        // Filter by Beauty & Care
        shopPage.selectCategory("Beauty & Care");
        page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(firstProductCard).isVisible();
        assertThat(firstProductCard).containsText("Beauty & Care");
    }

    // --- TEST 2: FILTER BY PRESET PRICE RANGE CAPSULES ---
    @Test
    public void testPriceRangePresetFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        shopPage.selectPriceRangePreset("$0–$25");
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertThat(firstProductCard).isVisible();
        assertThat(page).hasURL(java.util.regex.Pattern.compile("maxPrice=25"));
    }

    // --- TEST 3: FILTER BY SIZE ---
    @Test
    public void testSizeFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        // 1. Click the size filter option
        shopPage.selectSize("M");
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // 2. Assert that the items successfully re-render and are visible on the grid screen
        assertThat(firstProductCard).isVisible();

        // 3. Alternative Verification: Check that the browser's URL query string registered the size filter
        assertThat(page).hasURL(java.util.regex.Pattern.compile("size=M"));
    }

    // --- STEP 4: COMBINE ALL FILTERS AND ADD COLOR FILTER ---
    @Test(priority = 4)
    public void testColorFiltering() {
        Locator firstProductCard = page.locator("a.group.card-hover.block").first();

        // 1. Click the "White" color circle option in the sidebar
        shopPage.selectColor(ProductColors.WHITE_COLOR);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // 2. Assert that the product grid updates and items remain visible
        assertThat(firstProductCard).isVisible();

        // 3. Verify that the URL successfully appends the color query parameter
        assertThat(page).hasURL(java.util.regex.Pattern.compile("color=White"));
    }
}