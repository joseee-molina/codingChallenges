package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x9DifferentArraysSameBSTTest extends a4x9DifferentArraysSameBST {

    @Test
    public void test1(){
        TreeNode root = new TreeNode(2);
        BinaryTree bt = new BinaryTree(root);
        root.left=new TreeNode(1);
        root.right = new TreeNode(3);
        printAllPossibleArraysThatCreateSomeBinaryTree(bt);
        /**
         * It worked with the example in the CTCI book, so now let's
         * try something more complicated.
         */
        root.left.left = new TreeNode(0);
        root.right.right = new TreeNode(5);
        root.right.right.right=new TreeNode(6);
        bt.printInorder();

        printAllPossibleArraysThatCreateSomeBinaryTree(bt);
    }

}