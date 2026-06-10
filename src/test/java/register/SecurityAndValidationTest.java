package register;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.RegisterPage;
import constants.Expected;
import constants.Data;
import static org.testng.Assert.assertTrue;

public class SecurityAndValidationTest extends BaseTest {

    @Test(priority = 1)
    public void testRegistrationWithEmptyFields() {
        page.navigate(Expected.RegisterPageLink);
        RegisterPage registerPage = new RegisterPage(page);

        registerPage.registerWithCustomData(Data.emptyInput, Data.emptyInput, Data.emptyInput, Data.emptyInput);

        // This verifies that submission failed because the URL didn't change
        assertTrue(page.url().equals(Expected.RegisterPageLink), Expected.EmptyFieldsAssertionMsg);
    }

    @Test(priority = 2)
    public void testRegistrationWithInvalidEmailFormat() {
        page.navigate(Expected.RegisterPageLink);
        RegisterPage registerPage = new RegisterPage(page);

        registerPage.registerWithCustomData(Data.registerFirstName, Data.registerLastName, Data.invalidEmailFormat, Data.registerPassword);

        assertTrue(page.url().equals(Expected.RegisterPageLink), Expected.InvalidEmailAssertionMsg);
    }

    @Test(priority = 3)
    public void testRegistrationPasswordTooShort() {
        page.navigate(Expected.RegisterPageLink);
        RegisterPage registerPage = new RegisterPage(page);

        registerPage.registerWithCustomData(Data.registerFirstName, Data.registerLastName, Data.getRegisterEmail(), Data.shortPassword);

        assertTrue(page.url().equals(Expected.RegisterPageLink), Expected.ShortPasswordAssertionMsg);
    }
}