import org.junit.jupiter.api.*;

public class RepeatedTests {

    @RepeatedTest(5)
    @Order(1)
    void testRepeatedTests() {
        System.out.println("Repeated Test");
    }

    @RepeatedTest(value = 5, name = "{currentRepetition} out of {totalRepetitions} test repeated")
    @Order(2)
    void changeRepetitionTestName() {
        System.out.println("Repeated Test2");
    }

    @RepeatedTest(value = 5, name = "I am test {currentRepetition}")
    @DisplayName("Using a @DisplayName here")
    @Order(3)
    void changeRepetitionTestName2() {
        System.out.println("Repeated Test3");
    }

    @RepeatedTest(5)
    void usingRepetitionInfo(RepetitionInfo repetitionInfo) {
        System.out.println("Repeated Test4");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() > 3, () -> System.out.println("Current repetition: " + repetitionInfo.getCurrentRepetition()));
    }
}
