import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTests {
    @Test
    void testAssertEqualsTest(){
        assertEquals("firstString", "secondString", "The string values were not equal");
    }

    @Test
    void assertEqualListTest(){
        List<String> list1 = List.of("firstString", "secondString", "thirdString");
        List<String> list2 = List.of("firstString", "secondString", "thirdString");
        assertEquals(list1, list2);
    }

    @Test
    void assertArrayTest(){
        int[] list1 = {1, 2, 3};
        int[] list2 = {4, 5, 6};
        assertArrayEquals(list1, list2);
    }

    @Test
    void asserTrueTest(){
        assertTrue(false, "The boolean condition was not true");
    }
    @Test
    void asserFalseTest(){
        assertFalse(true, "The boolean condition was not false");
    }
    @Test
    void assertThrowsExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> {throw new IllegalArgumentException();});
    }
    @Test
    void assertAllTest(){
        assertAll(
                () -> assertFalse(true, "The boolean condition was not false"),
                () -> assertTrue(true, "The boolean condition was not true")
        );
    }
}
