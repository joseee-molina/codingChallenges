package chap4;

public class a4x10CheckSubtreeOfAnotherTree extends BinaryTree{
    public boolean checkSubtree(BinaryTree b1, BinaryTree b2){
        /**
         * b1 is the main, b2 is the may be subtree
         */
        return checkSubtreeHelper(b1.root, b2.root);
    }

    public boolean checkSubtreeHelper(TreeNode b1, TreeNode b2){
        if(b1==null){
            return false;
        }
        if(b1 == b2){
            /**
             * check equality
             */
            return checkTreeEquality(b1, b2);

        }

        return checkSubtreeHelper(b1.left,b2) || checkSubtreeHelper(b2.right,b2);
    }

    /**
     *
     * Checking if two trees are equal
     */

    public boolean checkTreeEquality(TreeNode b1, TreeNode b2){
        if(!b1.equals(b2)){
            return false;
        }

        if(b1==null && b2 == null){
            return true;
        }

        return checkTreeEquality(b1.left,b2.left) && checkTreeEquality(b1.right, b2.right);

    }
}
