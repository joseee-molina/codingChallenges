package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest extends BinaryTree {
    @Test
    public void minimumBSTTest(){
        int[] nums = {1,2,3,4};
        BinaryTree bst = minimumBST(nums);
        bst.printInorder();
    }

}