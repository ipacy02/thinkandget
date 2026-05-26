package addToCart;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void testAddSpecificProductToCart() {

        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        loginPage.login();
        homePage.addToCart();
    }
    }


