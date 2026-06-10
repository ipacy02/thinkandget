package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import constants.Data;
import constants.locators.LoginLocators; // Imported constants reference

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public HomePage login() {
        navigateToLoginPage();

        page.click(LoginLocators.SUBMIT_BUTTON);
        page.locator(LoginLocators.EMAIL_INPUT).waitFor();

        page.fill(LoginLocators.EMAIL_INPUT, Data.loginEmail);
        page.fill(LoginLocators.PASSWORD_INPUT, Data.loginPassword);
        page.click(LoginLocators.SUBMIT_BUTTON);

        page.locator(LoginLocators.SHOP_NAV_LINK)
                .filter(new Locator.FilterOptions().setHasText(LoginLocators.SHOP_NAV_TEXT))
                .waitFor();

        return new HomePage(page);
    }

    public void loginWithCustomData(String email, String password) {
        navigateToLoginPage();

        page.click(LoginLocators.SUBMIT_BUTTON);
        page.locator(LoginLocators.EMAIL_INPUT).waitFor();

        page.fill(LoginLocators.EMAIL_INPUT, email);
        page.fill(LoginLocators.PASSWORD_INPUT, password);
        page.click(LoginLocators.SUBMIT_BUTTON);
    }
}