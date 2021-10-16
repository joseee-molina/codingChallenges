package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x10CheckSubtreeOfAnotherTreeTest extends a4x10CheckSubtreeOfAnotherTree {

    @Test
    public void test1(){
        /**
         * First bt
         */
        TreeNode root = new TreeNode(0);
        BinaryTree bt1 = new BinaryTree(root);
        root.left = new TreeNode(1);
        root.right=new TreeNode(2);
        root.left.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
        /**
         * Subtree
         */
        TreeNode root2 = new TreeNode(0);
        BinaryTree bt2 = new BinaryTree(root2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(2);
        /**
         * Checking equality
         */
        assertTrue(checkSubtree(bt1,bt2));
        /**
         * Complexity:
         * O(N1*N2) time, where N1 is the size of the first tree, and N2 the size of the second
         * Same for space, since we're doing recursive calls and that takes space
         */

    }

}