package flow;

import com.microsoft.playwright.Page;
import pages.HomePage;
import pages.LoginPage;

public class Auth {
    LoginPage loginPage;

    public Auth(Page page){
        this.loginPage = new LoginPage(page);
    }

    public HomePage login(){
        return loginPage.login();
    }
}
