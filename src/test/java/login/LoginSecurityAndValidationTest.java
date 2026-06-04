package login;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import constants.Expected;
import constants.Data;
import static org.testng.Assert.assertTrue;

public class LoginSecurityAndValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testLoginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginWithCustomData(Data.emptyInput, Data.emptyInput);

        // Assert that the user remains locked inside the login panel view
        assertTrue(page.url().equals(Expected.LoginPageLink), Expected.EmptyLoginAssertionMsg);
    }

    @Test(priority = 2)
    public void testLoginWithWrongCredentials() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.loginWithCustomData(Data.wrongLoginEmail, Data.wrongLoginPassword);

        // Assert that the application did not redirect to the dashboard or products catalog
        assertTrue(page.url().equals(Expected.LoginPageLink), Expected.WrongLoginAssertionMsg);
    }
}