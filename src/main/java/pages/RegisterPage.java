package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import constants.Data;
import constants.locators.RegisterLocators; // Imported centralized registration selectors

public class RegisterPage extends BasePage {

    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator emailInput;
    private final Locator passwordInput;
    private final Locator submitRegisterButton;
    private final Locator errorAlert;

    public RegisterPage(Page page) {
        super(page);
        this.firstNameInput       = page.locator(RegisterLocators.FIRST_NAME_INPUT);
        this.lastNameInput        = page.locator(RegisterLocators.LAST_NAME_INPUT);
        this.emailInput           = page.locator(RegisterLocators.EMAIL_INPUT);
        this.passwordInput        = page.locator(RegisterLocators.PASSWORD_INPUT);
        this.submitRegisterButton = page.locator(RegisterLocators.SUBMIT_BUTTON);
        this.errorAlert           = page.locator(RegisterLocators.ERROR_ALERT_NODES);
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