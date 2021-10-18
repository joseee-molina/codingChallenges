package chap4;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a4x12NumberOfPathsThatAddToANumberInBTTest extends a4x12NumberOfPathsThatAddToANumberInBT {

    @Test
    public void test1(){

        TreeNode root = new TreeNode(1);
        BinaryTree bt = new BinaryTree(root);
        assertEquals(1,countNumberOfPathsThatAddUpTo(bt,1));
        root.left=new TreeNode(2);
        root.left.left=new TreeNode(4);
        root.right=new TreeNode(3);
        root.right.right=new TreeNode(3);
        root.right.left=new TreeNode(2);
        countNumberOfPathsThatAddUpTo(bt,6);
        assertEquals(countNumberOfPathsThatAddUpTo(bt,6),3);
        assertEquals(countNumberOfPathsThatAddUpTo(bt,5),1);
        assertEquals(countNumberOfPathsThatAddUpTo(bt,3),3);
        /**
         * In the worst case, you will traverse N nodes, then N-1 then N-2
         * until you finish traversing ever possible path, so the solution
         * will be time complexity will be N^2 and the space as well
         **/
    }

}