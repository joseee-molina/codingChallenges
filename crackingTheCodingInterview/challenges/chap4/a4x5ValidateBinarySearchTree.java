package chap4;

public class a4x5ValidateBinarySearchTree extends BinaryTree{

    public boolean isBinarySearchTree(BinaryTree bt){

        return isBSTHelper(bt.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBSTHelper(TreeNode<Integer> root, int min, int max){

        if(root == null){
            return true;
        }

        if(root.item>=max || root.item<=min){
            return false;
        }

        return isBSTHelper(root.left, min, root.item) && isBSTHelper(root.right, root.item, max);

    }

}
