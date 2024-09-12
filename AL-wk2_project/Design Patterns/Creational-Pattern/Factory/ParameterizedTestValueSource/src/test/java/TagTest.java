import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TagTest {
    @Test
    @Tag("sanity")
     void firstTest() {
        System.out.println("First Test");
    }
    @Test
    @Tag("sanity")
    @Tag("acceptance")
    void secondTest() {
        System.out.println("Second Test");
    }
    @Test
    @Tag("acceptance")
    void thirdTest() {
        System.out.println("Third Test");
    }

    @Tag("acceptance")
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int value){
        System.out.println("the parameter = " + value);
    }
}
