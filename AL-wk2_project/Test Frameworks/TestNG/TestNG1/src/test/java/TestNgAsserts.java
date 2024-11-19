import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNgAsserts {
    SoftAssert softAssert = new SoftAssert();

    @Test(groups = {"prod", "test"})
    public void testAssert() {
        Assert.assertTrue(2 < 3);
//        softAssert.assertTrue(2 == 3);
        Assert.assertEquals(4%2, 0);
        softAssert.assertAll();
    }
}
