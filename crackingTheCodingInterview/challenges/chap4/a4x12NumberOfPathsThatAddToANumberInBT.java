package chap4;

import java.util.HashMap;
import java.util.HashSet;

public class a4x12NumberOfPathsThatAddToANumberInBT extends BinaryTree{
    /**
     * The problem is to find the number of paths that add up to a certain
     * number in a binary tree. This problem is a bit challenging. So the
     * idea is the following.
     * 1. Have a class variable called "number of paths"
     * 2. Start from root node traversing every node looking for the correct
     * sum
     * 3. Do the same starting from the child nodes of the respective node.
     */

    private int numOfPAths;

    public int countNumberOfPathsThatAddUpTo(BinaryTree bt, int n){
        numOfPAths = 0;
        countNumberOfPathsHelper(bt.root,0,n, new HashMap<>());
        return numOfPAths;

    }

    private void countNumberOfPathsHelper(TreeNode node, int sum, int n, HashMap<TreeNode,Integer> visited){
        if(visited.containsKey(node) && visited.get(node)>2){
            return;
        }
        if(visited.containsKey(node)){
            visited.put(node,visited.get(node)+1);
        }
        else{
            visited.put(node,1);
        }
        sum+=(int)node.item;
        /**
         * We add this to make sure we dont count more than needed in the leafs
         */
        if(sum==n){
            numOfPAths++;
        }
        if(node.right!=null){
            countNumberOfPathsHelper(node.right, sum, n,visited);
            countNumberOfPathsHelper(node.right,0,n,visited);
        }
        if(node.left!=null){
            countNumberOfPathsHelper(node.left,sum,n,visited);
            countNumberOfPathsHelper(node.left,0,n,visited);
        }
    }

}
