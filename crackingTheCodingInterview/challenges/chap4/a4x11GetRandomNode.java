package chap4;

import java.util.LinkedList;
import java.util.Random;

public class a4x11GetRandomNode extends BinaryTree{
    /**
     * The objective here is to get a random node from
     * a binary tree. What I can do is:
     * 1. Choose a random number between 0 and the size
     * of the tree.
     * 2. Traverse the tree until that number gets to 0.
     * 3. Return that node.
     *  Time complexity: O(N)
     *  Space complexity: O(1)
     *
     */
    public int randNum = 0;

    public TreeNode getRandomNode(BinaryTree bt){
        TreeNode root = bt.root;
        LinkedList<TreeNode> llst = new LinkedList<>();
        Random randomGen = new Random(32);
        this.randNum = randomGen.nextInt(bt.size);
        getRandomNodeHelper(root,llst);
        return
    }

    private void getRandomNodeHelper(TreeNode node, LinkedList llst){
        if(randNum==0){
            llst.addFirst(node);
        }
        if(node.left!=null){
            randNum--;
            getRandomNodeHelper(node.left,llst);
        }
        if(node.right!=null){
            randNum--;
            getRandomNodeHelper(node.right,llst);
        }
    }

}
