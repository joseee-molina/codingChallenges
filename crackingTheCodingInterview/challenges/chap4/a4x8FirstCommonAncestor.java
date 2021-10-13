package chap4;

public class a4x8FirstCommonAncestor extends BinaryTree{

    /**
     * The idea is that when you have two nodes in the same level, you can go up
     * simultaneously and then the first node that is equal on those two pointers is going
     * to be the first common ancestor. However, there was no "parent" attribute mentioned,
     * so I doubt that implementation is possible here. In that case, we have an O(N) time
     * complexity and an O(1) space complexity.
     *
     * I will do that, since that is what is going to make this solution beautiful, and if
     * the "parent" attribute is not implemented yet, I can do that in O(N) time and space
     * using a traversal
     */

    public TreeNode getFirstCommonAncestor(TreeNode n1, TreeNode n2, BinaryTree bt){
        setParents(bt.root);
        int h1 = height(n1);
        int h2 = height(n2);
        TreeNode ptr1 = n1;
        TreeNode ptr2 = n2;
        if(h1>h2){
            getThisNodeUpNLevels(ptr2, h1-h2);
        }
        else{
            getThisNodeUpNLevels(ptr1,h2-h1);
        }

        return findCommonAncestorOfTwoNodeInSameLEvel(ptr1,ptr2);
    }

    public void getThisNodeUpNLevels(TreeNode node, int n){
        while(n>0){
            node = node.parent;
            n--;
        }
    }

    public TreeNode findCommonAncestorOfTwoNodeInSameLEvel(TreeNode n1, TreeNode n2){
        while(n1!=n2){
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1;
    }

    public void setParents(TreeNode n){
        if(n.left!=null){
            n.left.parent = n;
            setParents(n.left);
        }
        if(n.right!=null){
            n.right.parent = n;
            setParents(n.right);
        }
    }

}
