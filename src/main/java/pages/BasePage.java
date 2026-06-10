package pages;

import com.microsoft.playwright.Page;
import constants.locators.BaseLocators;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public LoginPage navigateToLoginPage() {
        page.locator(BaseLocators.NAVIGATE_LOGIN_BUTTON).click();
        return new LoginPage(page);
    }

    public RegisterPage clickCreateAccount() {
        page.locator(BaseLocators.CREATE_ACCOUNT_ANCHOR_XPATH).click();
        return new RegisterPage(page);
    }
}