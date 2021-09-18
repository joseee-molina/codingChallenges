import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x7rotateMatrix90DegreesTest extends a1x7rotateMatrix90Degrees {
    @Test
    public void test1(){
        int[][] mat = new int [4][4];
        fillMatrixWithConsecutiveIntegers(mat);
        rotate90Degrees(mat);
        
    }
}