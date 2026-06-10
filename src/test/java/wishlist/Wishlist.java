package wishlist;

import Base.BaseTest;
import constants.locators.WishlistLocators;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.WishlistPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Wishlist extends BaseTest {

    private HomePage homePage;
    private WishlistPage wishlistPage;

    @BeforeMethod
    public void setUpWishlistPreconditions() {
        page.setViewportSize(1440, 900);
        LoginPage loginPage = new LoginPage(page);
        homePage = loginPage.login();
    }

    @Test
    public void testEmptyWishlistLayoutState() {
        homePage.addItemToWishlist();

        wishlistPage = homePage.navigateToWishlistPage();

        wishlistPage.removeItemFromWishlist();

        assertThat(wishlistPage.getEmptyStateMessage()).isVisible();

        wishlistPage.clickExploreProducts();

        assertThat(page).hasURL(WishlistLocators.EXPLORE_REDIRECT_URL_PATTERN);
    }

    @Test
    public void testAddProductToWishlistSuccessfully() {
        homePage.addItemToWishlist();
        wishlistPage = homePage.navigateToWishlistPage();

        assertThat(wishlistPage.getEmptyStateMessage()).isHidden();
    }
}