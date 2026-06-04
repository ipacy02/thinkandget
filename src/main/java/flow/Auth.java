package flow;

import com.microsoft.playwright.Page;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

public class Auth {
    private final LoginPage loginPage;
    private final RegisterPage registerPage;

    public Auth(Page page) {
        this.loginPage = new LoginPage(page);
        this.registerPage = new RegisterPage(page);
    }

    public HomePage login() {
        return loginPage.login();
    }

    public HomePage register() {
        return registerPage.registerNewUser();
    }
}