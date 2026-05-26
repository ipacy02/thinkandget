package flow;

import com.microsoft.playwright.Page;
import pages.HomePage;

public class addToCartFlow {
    Auth auth;

    public addToCartFlow(Page page){
        this.auth = new Auth(page);
    }
}
