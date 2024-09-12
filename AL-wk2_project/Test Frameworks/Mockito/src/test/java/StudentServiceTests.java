import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.List;

public class StudentServiceTests {
    @Mock
    private List<String> list;

    @InjectMocks
    private Main.StudentService studentService;

    @BeforeEach
    void testInit(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void studentListWasSetTwiceTest(){
        studentService.addStudent("Kingsley");
        studentService.addStudent("George");
        Assertions.assertFalse(studentService.getList().isEmpty());
        Mockito.verify(list, Mockito.times(2)).add(Mockito.anyString());
        Mockito.verify(list, Mockito.atLeastOnce()).add(Mockito.anyString());
    }

    @Test
    void verifyMethodNeverCalled(){
        Mockito.verify(list, Mockito.never()).set(Mockito.anyInt(), Mockito.anyString());
        Mockito.when(list.get(Mockito.eq(0))).thenReturn("Kingsley");
        Assertions.assertNotEquals("Kingsley", studentService.getList().get(1));
        Assertions.assertEquals("Kingsley", studentService.getList().get(0));
    }

    @Test
    void getStudentTest(){
        Mockito.when(list.get(0)).thenReturn("Kingsley"); //stubbing
        Assertions.assertEquals("Kingsley", studentService.getStudent(0));
    }

}
