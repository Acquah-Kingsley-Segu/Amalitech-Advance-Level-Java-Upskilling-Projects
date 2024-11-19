import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)

public class ListMockTest {
    @Mock
    List<String> list;
    @Spy
    List<String> spyList = new ArrayList<>();

    /** Notes on mock Mockito method
     * 1. Creates a proxy object of the mocked class
     * 2. Creates a memory space
     * 3. The memory space does not hold
     *    the actual internal representation of the class
     * 4. It holds information about the mocked instance
     *    related to mockito
     * 5. So all method called on a mocked instance does not
     *    happen in reality.
     */
    @Test
    void testManualMocks() {
        List<String> mockedList = Mockito.mock(ArrayList.class);
        mockedList.add("a");
        Mockito.verify(mockedList).add("a");

        Assertions.assertNull(mockedList.get(0));
        Assertions.assertEquals(0, mockedList.size());

        // Stubbing
        Mockito.when(mockedList.get(0)).thenReturn("a");
        Assertions.assertEquals("a", mockedList.get(0));

        Mockito.when(mockedList.size()).thenReturn(100);
        Assertions.assertEquals(100, mockedList.size());
    }

    /**
     * Notes on spy Mockito method
     * 1. Creates two memory spaces
     *     a. One for the mocked class
     *     b. One for use by mockito
     * 2. For this reason, all methods called on
     *    a mocked class actual have a physical implications
     */
    @Test
    void testManualSpy(){
        List<String> mockedList = Mockito.spy(new ArrayList<>());
        mockedList.add("a");
        Mockito.verify(mockedList).add("a");
        Assertions.assertEquals("a", mockedList.get(0));
        Assertions.assertEquals(1, mockedList.size());
    }

    @Test
    void testAnnotatedMocks(){
        list.add("a");
        Mockito.verify(list).add("a");
        Assertions.assertNull(list.get(0));
        Assertions.assertEquals(0, list.size());

        // Stubbing
        Mockito.when(list.get(0)).thenReturn("a");
        Assertions.assertEquals("a", list.get(0));
        Mockito.when(list.size()).thenReturn(100);
        Assertions.assertEquals(100, list.size());
    }

    @Test
    void testAnnotatedSpy(){
        spyList.add("a");
        Mockito.verify(spyList).add("a");
        Assertions.assertEquals("a", spyList.get(0));
        Assertions.assertEquals(1, spyList.size());
    }
}
