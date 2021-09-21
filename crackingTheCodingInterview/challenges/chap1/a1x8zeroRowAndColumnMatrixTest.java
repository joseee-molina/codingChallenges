package chap1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x8zeroRowAndColumnMatrixTest extends a1x8zeroRowAndColumnMatrix {

    @Test
    public void test1(){
        int[][] mat1 = new int[5][5];
        a1x8zeroRowAndColumnMatrix.fillMatrixWithConsecutiveIntegers(mat1);
        mat1[2][3] = 0;
        //mat1[0][0] = 0;
        mat1[4][2] = 0;
        a1x8zeroRowAndColumnMatrix.makeZeroRowAndColumn(mat1);
        //ok! it is working fine
        //the true here is that it should be hard to do this in place, but i will think of an alternative later

    }


}