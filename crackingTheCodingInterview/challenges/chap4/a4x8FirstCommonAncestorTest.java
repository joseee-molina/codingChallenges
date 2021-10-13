package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x8FirstCommonAncestorTest extends a4x8FirstCommonAncestor {

    @Test
    public void test1(){
        TreeNode root = new TreeNode(0);
        BinaryTree bt = new BinaryTree(root);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.left.right.left.right = new TreeNode(7);
        TreeNode n1 = root.left.right.right;
        TreeNode n2 = root.left.right.left.right;
        System.out.println(getFirstCommonAncestor(n1,n2,bt).item);

    }

}