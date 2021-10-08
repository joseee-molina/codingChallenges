package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest extends BinaryTree {
    @Test
    public void minimumBSTTest(){
        int[] nums = {1,2,3};
        BinaryTree bst = minimumBST(nums);
        bst.printInorder();
        int[] n2 = {3,3,3,4,5,5,5,7};
        minimumBST(n2).printInorder();
    }

}