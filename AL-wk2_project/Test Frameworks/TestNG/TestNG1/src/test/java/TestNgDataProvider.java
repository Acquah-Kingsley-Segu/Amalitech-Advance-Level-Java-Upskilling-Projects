import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNgDataProvider {

    @Test(dataProvider = "credentials", groups = "test")
    public void test(String name, String password) {
        System.out.println("Name: " + name + ", Password: " + password);
    }

    @Test(dataProviderClass = UserProfileDataSource.class, dataProvider = "user-profiles")
    public void testUserProfile(String name, String email, String gender) {
        System.out.println("Name: " + name + ", Email: " + email + ", Gender: " + gender);
    }

    @Test(dataProviderClass = UserProfileDataSource.class, dataProvider = "user-credentials")
    public void testUserCredentials(String name, String password) {
        System.out.println("Name: " + name + ", Password: " + password);
    }


    @DataProvider
    public Object[][] credentials(){
        Object[][] credentials = new Object[2][2];
        credentials[0][0] = "Paul"; credentials[0][1] = "paul_password";
        credentials[1][0] = "John"; credentials[1][1] = "john_password";

        return credentials;
    }
}
