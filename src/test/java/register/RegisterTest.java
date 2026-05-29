package register;

import Base.BaseTest;
import flow.Auth;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import com.microsoft.playwright.options.LoadState;

public class RegisterTest extends BaseTest {

    @Test
    public void testUserRegistrationViaFlow() {
        page.setViewportSize(1440, 900);

        Auth auth = new Auth(page);

        auth.register();

        page.waitForLoadState(LoadState.NETWORKIDLE);
    }
}