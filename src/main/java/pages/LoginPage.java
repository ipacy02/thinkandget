package pages;

import com.microsoft.playwright.Page;
import constants.Data;

public class LoginPage extends BasePage {

    public LoginPage(Page page) {
        super(page);
    }

    public HomePage login() {
        navigateToLoginPage();

        page.click("button[type='submit']");

        // 1. Guard: Wait for the login form to visually load before typing
        page.locator("input[type='email']").waitFor();

        page.fill("input[type='email']", Data.loginEmail);
        page.fill("input[type='password']",Data.loginPassword);
        page.click("button[type='submit']");


        page.locator("nav a").filter(new com.microsoft.playwright.Locator.FilterOptions().setHasText("Shop")).waitFor();
        return new HomePage(page);
    }
}