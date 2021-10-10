package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x5ValidateBinarySearchTreeTest extends a4x5ValidateBinarySearchTree {

    @Test
    public void testisBST(){
        TreeNode root = new TreeNode(3);
        BinaryTree bt = new BinaryTree(root);
        root.left= new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        assertTrue(isBinarySearchTree(bt));
        root.left.left.left = new TreeNode(2);
        assertFalse(isBinarySearchTree(bt));

    }

    @Test
    public void testisBSTEdgeCases(){
        
    }

}