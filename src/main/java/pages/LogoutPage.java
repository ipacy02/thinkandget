package pages;

import com.microsoft.playwright.Page;
import constants.locators.LogoutLocators;

public class LogoutPage extends BasePage{
    public LogoutPage(Page page) {
        super(page);
    }

    public void logout() {
        page.locator(LogoutLocators.USER_DROPDOWN_CONTAINER).hover();
        page.click(LogoutLocators.SIGN_OUT_BUTTON);
    }
}
