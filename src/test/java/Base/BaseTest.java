package Base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class BaseTest {
    // Shared single instances for the whole test suite run
    public static Playwright playwright;
    public static Browser browser;
    public BrowserContext context;
    protected Page page;


    @BeforeClass
    public void startEngine() {
        // Create the core Playwright process once for this test class
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(100));

    }

    @BeforeMethod
    public void setup() {
        // Create a completely brand-new browser sandbox environment (clears cookies/storage)
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://think-and-get-it-frontend.onrender.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Clean up the individual page tab and context sandbox right after the test ends
        if (context != null) {
            context.close();
        }
    }

    @AfterClass
    public void stopEngine() {
        // Tear down the heavy browser application binaries completely at the very end
        if (browser != null) {
            browser.close();
            playwright.close();
        }
    }
}