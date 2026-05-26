package pages;

import com.microsoft.playwright.Page;

public class LogoutPage extends BasePage{
    public LogoutPage(Page page) {
        super(page);
    }

    public void logout() {
        page.locator("div.relative.group:has-text('Sign out')").hover();
        page.click("text=Sign out");
    }
}
