package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class a4x12NumberOfPathsThatAddToANumberInBTTest extends a4x12NumberOfPathsThatAddToANumberInBT {

    @Test
    public void test1(){

        TreeNode root = new TreeNode(1);
        BinaryTree bt = new BinaryTree(root);
        countNumberOfPathsThatAddUpTo(bt,1);

    }

}