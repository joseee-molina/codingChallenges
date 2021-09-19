import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x8zeroRowAndColumnMatrixTest extends a1x8zeroRowAndColumnMatrix {

    @Test
    public void test1(){
        int[][] mat1 = new int[5][5];
        fillMatrixWithConsecutiveIntegers(mat1);
        mat1[2][3] = 0;
        mat1[0][0] = 0;
        mat1[4][2] = 0;
        makeZeroRowAndColumn(mat1);
    }


}