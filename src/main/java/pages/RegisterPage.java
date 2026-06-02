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

    // Added locator to read frontend validation messages dynamically
    private final Locator errorAlert;

    public RegisterPage(Page page) {
        super(page);
        this.firstNameInput = page.locator("input[placeholder='John']");
        this.lastNameInput = page.locator("input[placeholder='Doe']");

        this.emailInput = page.locator("input[placeholder='you@example.com']");
        this.passwordInput = page.locator("input[type='password']");

        this.submitRegisterButton = page.locator("button:has-text('Create account')");

        // Catches standard frontend alert elements, toast messages, or validation layout nodes
        this.errorAlert = page.locator("[role='alert'], .error-message, .text-red-500");
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


    public void registerWithCustomData(String firstName, String lastName, String email, String password) {
        firstNameInput.waitFor();

        firstNameInput.fill(firstName);
        lastNameInput.fill(lastName);
        emailInput.fill(email);
        passwordInput.fill(password);

        submitRegisterButton.click();
    }

    public String getErrorMessageText() {
        errorAlert.first().waitFor();
        return errorAlert.first().innerText().trim();
    }
}