import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgDependsOnMethod {
    /**
     * Methods depending on another are skipped
     * when the dependent method fails
     */
    @Test
    public void test1() {
        System.out.println("TestNgDependsOnMethod.test1");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "test1")
    public void test2() {
        System.out.println("TestNgDependsOnMethod.test2 depends on TestNgDependsOnMethod.test1");
    }
}
