package constants;

public class Expected {
    // Page redirection verification endpoints
    public static final String BaseLink = "https://think-and-get-it-frontend.onrender.com/";
    public static final String ShopLink = "https://think-and-get-it-frontend.onrender.com/products";
    public static final String Featurelink = "https://think-and-get-it-frontend.onrender.com/products?featured=true";
    public static final String FlashLink = "https://think-and-get-it-frontend.onrender.com/products?flash_sale=true";

    // Explicit form routes for page validation mapping
    public static final String RegisterPageLink = "https://think-and-get-it-frontend.onrender.com/register";
    public static final String LoginPageLink = "https://think-and-get-it-frontend.onrender.com/login";

    // Centralized Validation Error Messages (UI text)
    public static final String EmptyFieldsErrorMessage = "All fields are required";
    public static final String InvalidEmailErrorMessage = "Please enter a valid email address";
    public static final String PasswordTooShortErrorMessage = "Password must be at least 8 characters";
    public static final String InvalidCredentialsErrorMessage = "Invalid email or password";
    public static final String NoProductsFoundMessage = "No products found";

    // Centralized Test Assertion Failure Messages
    public static final String EmptyFieldsAssertionMsg = "The form submitted despite empty fields!";
    public static final String InvalidEmailAssertionMsg = "App accepted an invalid email format structure!";
    public static final String ShortPasswordAssertionMsg = "App allowed a password shorter than length constraints!";
    public static final String SortingFailedAssertionMsg = "Sorting failed: Screen is blank (neither products nor empty state message found)!";
    public static final String LowHighSortingAssertionMsg = "Prices are not sorted from Low to High!";
    public static final String HighLowSortingAssertionMsg = "Prices are not sorted from High to Low!";

    // Test Assertion Failure Messages
    public static final String EmptyLoginAssertionMsg = "The login form submitted despite empty fields!";
    public static final String WrongLoginAssertionMsg = "User managed to bypass authentication with incorrect credentials!";
}