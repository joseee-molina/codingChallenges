package chap4;

import java.util.LinkedList;

public class a4x4CheckBalanced extends BinaryTree{

    public static void main(String[] args) {

    }


    public boolean checkBalanced(BinaryTree bt){
        LinkedList<Integer> l = new LinkedList();
        checkBalancedHelper(bt.root,l);
        return l.size()==0;
    }

    public void checkBalancedHelper(TreeNode n, LinkedList<Integer> l){

        if(Math.abs(height(n.left)-height(n.right))>1){
            if(l.size()<=1){
                l.add(1);
            }
        }

        if(n.left!=null){
            checkBalancedHelper(n.left,l);
        }
        if(n.right!=null){
            checkBalancedHelper(n.right,l);
        }


    }

}
