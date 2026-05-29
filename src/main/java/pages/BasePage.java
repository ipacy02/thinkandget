package pages;

import com.microsoft.playwright.Page;

public class BasePage {
    protected  Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public LoginPage navigateToLoginPage() {
        page.locator(".btn-ghost.text-sm.py-2.px-4").click();
       return new LoginPage(page);
    }

    public RegisterPage clickCreateAccount() {

        page.locator("//a[@class='btn-ghost text-base py-4 px-8']").click();
        return new RegisterPage(page);

    }
}
