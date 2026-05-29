package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import constants.Data;

public class RegisterPage extends BasePage {

    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator submitRegisterButton;

    public RegisterPage(Page page) {
        super(page);
        this.firstNameInput = page.locator("input[placeholder='John']");
        this.lastNameInput = page.locator("input[placeholder='Doe']");

        this.emailInput = page.locator("input[placeholder='you@example.com']");
        this.passwordInput = page.locator("input[type='password']");

        this.submitRegisterButton = page.locator("button:has-text('Create account')");
    }

    public HomePage registerNewUser() {
        clickCreateAccount();
        firstNameInput.waitFor();

        firstNameInput.fill(Data.registerFirstName);
        lastNameInput.fill(Data.registerLastName);
        emailInput.fill(Data.getRegisterEmail());
        passwordInput.fill(Data.registerPassword);
        submitRegisterButton.click();

        return new HomePage(page);
    }
}