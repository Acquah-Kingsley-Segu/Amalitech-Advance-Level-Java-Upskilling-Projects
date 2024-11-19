import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgGroup {
    @Test(groups = "test1")
    public void test1() {
        System.out.println("Test 1");
        Assert.assertTrue(false);
    }
    @Test(dependsOnGroups = "test1")
    public void test2() {
        System.out.println("Test 2");
    }
}
