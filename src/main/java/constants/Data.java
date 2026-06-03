package constants;

public class Data {
    public static final String loginEmail = "mirimo@gmail.com";
    public static final String loginPassword = "mirimo2020";

    // --- HAPPY PATH REGISTRATION ---
    public static final String registerFirstName = "Manzi";
    public static final String registerLastName = "Craig";
    public static final String registerPassword = "mirimo2020Password!";

     //Generates a unique email dynamically for every test run.

    public static String getRegisterEmail() {
        return "manzi_craig_" + System.currentTimeMillis() + "@gmail.com";
    }
    public static final String emptyInput = "";

    public static final String invalidEmailFormat = "manzi_craig_invalid.com";

    public static final String shortPassword = "123";

    public static final String wrongLoginEmail = "completely_wrong_email@gmail.com";
    public static final String wrongLoginPassword = "incorrectPassword123";

}