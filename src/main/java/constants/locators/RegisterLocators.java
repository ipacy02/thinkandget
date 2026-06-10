package constants.locators;

public final class RegisterLocators {

    private RegisterLocators() {}

    // --- FORM INPUT FIELDS ---
    public static final String FIRST_NAME_INPUT  = "input[placeholder='John']";
    public static final String LAST_NAME_INPUT   = "input[placeholder='Doe']";
    public static final String EMAIL_INPUT       = "input[placeholder='you@example.com']";
    public static final String PASSWORD_INPUT    = "input[type='password']";

    // --- ACTION BUTTONS ---
    public static final String SUBMIT_BUTTON     = "button:has-text('Create account')";

    // --- ERROR & VALIDATION ALERTS ---
    public static final String ERROR_ALERT_NODES = "[role='alert'], .error-message, .text-red-500";
}