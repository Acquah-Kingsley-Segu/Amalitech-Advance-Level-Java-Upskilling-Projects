import org.testng.annotations.DataProvider;

public class UserProfileDataSource {
    @DataProvider(name = "user-profiles")
    public static Object[][] getUserProfile() {
        Object[][] userProfiles = new Object[2][3];
        userProfiles[0][0] = "John Doe"; userProfiles[0][1] = "johndoe@gmail.com"; userProfiles[0][2] = "male";
        userProfiles[1][0] = "Jennifer Thompson"; userProfiles[1][1] = "thompson@gmail.com"; userProfiles[1][2] = "female";

        return userProfiles;
    }

    @DataProvider(name = "user-credentials")
    public static Object[][] getUserCredentials() {
        Object[][] userCredentials = new Object[2][2];
        userCredentials[0][0] = "John Doe"; userCredentials[0][1] = "john_doe";
        userCredentials[1][0] = "Jennifer Thompson"; userCredentials[1][1] = "jennifer_thompson";

        return userCredentials;
    }
}
