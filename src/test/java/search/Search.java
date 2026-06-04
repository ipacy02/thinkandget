package search;

import Base.BaseTest;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ShopPage;
import constants.ProductSearch;
import constants.ShopLocators; // Imported for the final negative assertion card match

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Search extends BaseTest {

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

    @Test(priority = 1)
    public void testSearchVintageLeatherShoulderBag() {
        shopPage.searchProduct(ProductSearch.VINTAGE_BAG);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        Locator resultsHeader = shopPage.getSearchResultsHeader();
        assertThat(resultsHeader).isVisible();
        assertThat(resultsHeader).containsText(ProductSearch.VINTAGE_BAG);

        Locator productCard = shopPage.getProductCardByName(ProductSearch.VINTAGE_BAG);
        assertThat(productCard).isVisible();
    }

    @Test(priority = 2)
    public void testSearchUnavailableProduct() {
        shopPage.searchProduct(ProductSearch.INVALID_ITEM);
        page.waitForLoadState(LoadState.NETWORKIDLE);

        // Uses our exact unified card constant rather than a duplicate hardcoded string
        Locator genericCard = page.locator(ShopLocators.PRODUCT_CARD_ANCHOR).first();
        assertThat(genericCard).not().isVisible();
    }
}