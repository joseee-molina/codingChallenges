package chap8;

import org.junit.Test;

import static org.junit.Assert.*;

public class _8_2_RobotPathTest extends _8_2_RobotPath {
    @Test
    public void test1(){
        int[][] board1 = new int[3][4];
        board1[0][2] = 1;
        board1[1][1] = 1;
        print2DArr(board1);
        findPathToEnd(board1);
        //cool, worked. You can try with you own solutions!!
    }
}