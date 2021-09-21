package chap1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x7rotateMatrix90DegreesTest extends a1x7rotateMatrix90Degrees {
    @Test
    public void test1(){
        int[][] mat = new int [4][4];
        a1x7rotateMatrix90Degrees.fillMatrixWithConsecutiveIntegers(mat);
        a1x7rotateMatrix90Degrees.rotate90Degrees(mat);
        //passed this test aparently, what about nonsquarematrices?
        int[][] mat2 = new int[2][3];
        a1x7rotateMatrix90Degrees.fillMatrixWithConsecutiveIntegers(mat2);
        //rotate90Degrees(mat2);
        //the in place method works only for sauqre matrices, because by definition you cannot modify ti
        //which is, that the dimensions of the original matrix are the same as teh resulting matrix
        //and you cannot make a 2-3 matrix into a 3-2 matrix
    }
}