import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class ValueSourceTests {
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    @ValueSource(ints = {1, 5, 6})
    void intValues(int value){
        System.out.println("the parameter = " + value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"firstValue", "secondValue"})
    @NullAndEmptySource
//    @EmptySource
//    @NullSource
    void stringValues(String value) {
        System.out.println("the parameter = " + value);
    }

    @ParameterizedTest
    @CsvSource(value = {"hulk,abomination", "superman,luther", "spiderman,venom"})
    void csvSourceStrings(String hero, String villain) {
        System.out.println("the hero = " + hero + " and the villain = " + villain);
    }

    @ParameterizedTest
    @CsvSource(value = {"hulk,200,false", "superman,230,true", "spiderman,100,true"})
    void csvSourceStringIntBoolean(String hero, int powerLevel, boolean userFavorite) {
        System.out.println("the hero = " + hero + ", the power level = " + powerLevel + " and user favorite = " + userFavorite);
    }
}
