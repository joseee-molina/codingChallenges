package chap4;

import chap2.DLList;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import chap2.DLListPublic;

public class a3x3ListOfDepths extends BinaryTree{
    /**
     * The idea is to have a list of nodes of the first depth, then, for every node at
     * the first depth, we're going to add their children in the next linked list,
     * and then, for every of those nodes we're going to add their nodes in the next on
     * and so on.
     *
     */

    public ArrayList<DLListPublic<TreeNode>> NodesPerLevel(BinaryTree bt){
        TreeNode root = bt.root;
        ArrayList<DLListPublic<TreeNode>> list = new ArrayList<>();
        DLListPublic<TreeNode> firstList = new DLListPublic();
        firstList.addLast(root);
        list.add(firstList);

        fillListWithNodes(list);
        return list;
    }

    public void fillListWithNodes(ArrayList<DLListPublic<TreeNode>> list){
        boolean weAreInTheLastDepth = false;
        while(!weAreInTheLastDepth){

            DLListPublic currentList = list.get(list.size()-1);
            weAreInTheLastDepth = currentList.size == 0 ? true : false;
            DLListPublic nextList = new DLListPublic();
            for(int i = 0 ; i<currentList.size;i++){
                TreeNode curr = (TreeNode) currentList.get(i);
                if(!curr.left.equals(null)){
                    nextList.addLast(curr.left);
                }
                if(!curr.right.equals(null)){
                    nextList.addLast(curr.right);
                }
            }
            list.add(nextList);
        }
    }

}
