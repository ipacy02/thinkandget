package constants;

public class Data {
    public static final String loginEmail = "mirimo@gmail.com";
    public static final String loginPassword = "mirimo2020";

    public static final String registerFirstName = "Manzi";
    public static final String registerLastName = "Craig";
    public static final String registerPassword = "mirimo2020Password!";


    public static String getRegisterEmail() {
        return "manzi_craig_" + System.currentTimeMillis() + "@gmail.com";
    }
}