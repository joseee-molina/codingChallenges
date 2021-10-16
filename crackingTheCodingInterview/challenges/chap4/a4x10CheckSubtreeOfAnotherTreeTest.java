package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class a4x10CheckSubtreeOfAnotherTreeTest extends a4x10CheckSubtreeOfAnotherTree {

    @Test
    public void test1(){
        /**
         * First bt
         */
        TreeNode root = new TreeNode(0);
        BinaryTree bt1 = new BinaryTree(root);
        root.left = new TreeNode(1);
        root.right=new TreeNode(2);

        /**
         * Subtree
         */

        TreeNode root2 = new TreeNode(0);
        BinaryTree bt2 = new BinaryTree(root2);
        root2.left = new TreeNode(1);


        /**
         * Checking equality
         */

    }

}