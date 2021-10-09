package chap4;

import com.sun.source.tree.Tree;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class a4x3ListOfDepthsTest extends a4x3ListOfDepths {
    @Test
    public void test1(){
        BinaryTree bt = new BinaryTree(new TreeNode(1));
        TreeNode root = bt.root;
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.left = new TreeNode(6);
        root.left.left.right.right = new TreeNode(7);
        root.right = new TreeNode(8);
        ArrayList arr = nodesPerLevel(bt);
        printListsPerLevel(arr);
        //It was very fun but weird exercise
    }
}