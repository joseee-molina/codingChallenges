package chap4;

public class a4x6InOrderSuccessor extends BinaryTree {
    public TreeNode getInOrderSuccessor(TreeNode n){
        if(n==null){
            return null;
        }
        if(n.right!=null){
            return n.right;
        }
        else{
            TreeNode curr = n;
            TreeNode parent = n.parent;

            while(parent.left != curr){
                curr = parent;
                parent = curr.parent;
                if(parent==null){
                    return null;
                }
            }
            return parent;
        }
    }
}
