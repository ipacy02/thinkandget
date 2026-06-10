package filter;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;
import constants.ProductSorting;
import constants.Expected;
import constants.locators.ShopLocators;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
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
        Locator firstProductCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        Locator emptyStateMessage = page.locator(ShopLocators.NO_PRODUCTS_MESSAGE)
                .filter(new Locator.FilterOptions().setHasText(Expected.NoProductsFoundMessage))
                .first();

        shopPage.selectSortOption(ProductSorting.POPULAR);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(firstProductCard.isVisible() || emptyStateMessage.isVisible(),
                Expected.SortingFailedAssertionMsg);

        // 2. LOW TO HIGH
        shopPage.selectSortOption(ProductSorting.PRICE_LOW_HIGH);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        if (firstProductCard.isVisible()) {
            List<Double> actualLowHighPrices = shopPage.getProductPrices();
            List<Double> expectedLowHighPrices = new ArrayList<>(actualLowHighPrices);
            Collections.sort(expectedLowHighPrices);
            assertEquals(actualLowHighPrices, expectedLowHighPrices, Expected.LowHighSortingAssertionMsg);
        } else {
            assertThat(emptyStateMessage).isVisible();
        }

        // 3. HIGH TO LOW
        shopPage.selectSortOption(ProductSorting.PRICE_HIGH_LOW);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        if (firstProductCard.isVisible()) {
            List<Double> actualHighLowPrices = shopPage.getProductPrices();
            List<Double> expectedHighLowPrices = new ArrayList<>(actualHighLowPrices);
            Collections.sort(expectedHighLowPrices, Collections.reverseOrder());
            assertEquals(actualHighLowPrices, expectedHighLowPrices, Expected.HighLowSortingAssertionMsg);
        } else {
            assertThat(emptyStateMessage).isVisible();
        }

        // 4. TOP RATED
        shopPage.selectSortOption(ProductSorting.TOP_RATED);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        assertTrue(firstProductCard.isVisible() || emptyStateMessage.isVisible(),
                Expected.SortingFailedAssertionMsg);
    }
}