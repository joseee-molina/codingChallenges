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
        if(b1.item.equals(b2.item)){
            /**
             * check equality
             */
            return !checkTreeInequality(b1, b2);

        }

        return checkSubtreeHelper(b1.left,b2) || checkSubtreeHelper(b1.right,b2);
    }

    /**
     *
     * Checking if two trees are equal
     */

    public boolean checkTreeInequality(TreeNode b1, TreeNode b2){

        if(b2==null && b1!=null){
            return false;
        }
        if((b1==null && b2!=null)){
            return true;
        }
        if(b1==null && b2 == null){
            return false;
        }
        if( !b1.item.equals(b2.item)){
            return true;
        }
        boolean bool1 = checkTreeInequality(b1.left,b2.left);
        boolean bool2 = checkTreeInequality(b1.right, b2.right);

        return bool1 || bool2;

    }
}
