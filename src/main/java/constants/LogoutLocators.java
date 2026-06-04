package constants;

public final class LogoutLocators {

    private LogoutLocators() {}

    // Selector targeting the user profile container or dropdown text area
    public static final String USER_DROPDOWN_CONTAINER = "div.relative.group:has-text('Sign out')";

    // Explicit selector targeting the Sign Out action item text
    public static final String SIGN_OUT_BUTTON         = "text=Sign out";
}