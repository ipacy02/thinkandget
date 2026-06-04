package Base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
    public static Playwright playwright;
    public static Browser browser;
    public BrowserContext context;
    protected Page page;


    @BeforeClass
    public void startEngine() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(true)
                .setSlowMo(100));

    }

    @BeforeMethod
    public void setup() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://think-and-get-it-frontend.onrender.com/");
    }

    @AfterMethod
    public void tearDown() {
        if (context != null) {
            context.close();
        }
    }

    @AfterClass
    public void stopEngine() {
        if (browser != null) {
            browser.close();
            playwright.close();
        }
    }
}