import org.example.operations.MatrixMultiplication;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatrixMultiplicationTest {
    static MatrixMultiplication matrixMultiplication;

    @BeforeAll
    static void instantiateObject() {
        try{
            matrixMultiplication = new MatrixMultiplication(new int[][]{{1, 2, 3}, {4, 5, 6,}}, new int[][]{{10, 11}, {20, 21}, {30, 31}}, 0, 2, 2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void extractColumnTest(){
        try{
            int[] arr = matrixMultiplication.extractColumn();
            assertArrayEquals(new int[]{10, 20, 30}, arr);
        }catch (NullPointerException e){
            System.out.println("ERROR: Constructor failed due to unsatisfied requirements");
        }
    }

    @Test
    public void multiplyRowColumnTest(){
        try{
            int[] arr = matrixMultiplication.multiplyRowColumn(new int[]{1, 2, 3}, new int[]{10, 20, 30});
            assertArrayEquals(new int[]{10, 40, 90}, arr);
        }catch (NullPointerException e){
            System.out.println("ERROR: Constructor failed due to unsatisfied requirements");
        }

    }

    @Test
    public void subMatrixA(){
        try{
            int[][] arr = matrixMultiplication.subMatrixA();
            assertArrayEquals(new int[][]{{4, 5, 6,}}, arr);
        }catch (NullPointerException e){
            System.out.println("ERROR: Constructor failed due to unsatisfied requirements");
        }
    }

    @Test
    public void computeMatrixMultiplicationTest(){
        try{
            int result = matrixMultiplication.computeMatrixMultiplication();
            assertEquals(140, result);
        }catch (NullPointerException e){
            System.out.println("ERROR: Constructor failed due to unsatisfied requirements");
        }
    }
}
