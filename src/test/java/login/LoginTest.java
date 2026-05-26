package login;

import Base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import flow.Auth;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {
    Auth auth;

    @BeforeMethod
    public void setAuth(){
        this.auth = new Auth(page);
    }
    @Test
    public void testLogin(){
        auth.login();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in"))).isHidden();  }
}
