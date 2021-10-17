package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x11GetRandomNodeTest extends a4x11GetRandomNode {

    @Test
    public void test1(){
        TreeNode root = new TreeNode(0);
        BinaryTree bt = new BinaryTree(root);

        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);

        System.out.println(getRandomNode(bt));

    }
}