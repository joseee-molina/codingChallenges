package chap4;

import java.util.ArrayList;

public class a4x9DifferentArraysSameBST extends BinaryTree{
    /**
     *
     * Sorry for not posting yesterday! It was a difficult day for me,
     * I had some problem here in the family but we're all good thankfully.
     * Or at least i think so. Well, going back to the problem, how to get
     * all the possible arrays that read from left to right give you some
     * binary search tree? The idea is in the levels, as long as you take
     * numbers from the same levels, you can shuffle them as you wish,
     * and the outputted bst will be the same.
     *
     * So, in a nutshell, we will
     * 1. Add nodes level per level
     * 2. Shuffle those nodes
     * 3. Be happy
     *
     */

    public void printAllPossibleArraysThatCreateSomeBinaryTree(BinaryTree bt){
        ArrayList currentLevel = new ArrayList();
        ArrayList nextLevel = new ArrayList();
        currentLevel.add(bt.root);

        while(!currentLevel.isEmpty()){
            System.out.println();
            permuteHelper(currentLevel,0);
            System.out.println();
            for(int i = 0 ; i<currentLevel.size();i++){
                TreeNode currNode = (TreeNode) currentLevel.get(i);
                if(currNode.left!=null){
                    nextLevel.add(currNode.left);
                }
                if(currNode.right!=null){
                    nextLevel.add(currNode.right);
                }
            }
            currentLevel = nextLevel;
            nextLevel = new ArrayList();
        }

    }

    private static void permuteHelper(ArrayList arr, int index){
        if(index >= arr.size() - 1){ //If we are at the last element - nothing left to permute
            //System.out.println(Arrays.toString(arr));
            //Print the array
            System.out.print("[");
            for(int i = 0; i < arr.size() - 1; i++){
                System.out.print(arr.get(i) + " ");
            }
            if(arr.size() > 0)
                System.out.print(arr.get(arr.size() - 1));
            System.out.println("]");
            return;
        }

        for(int i = index; i < arr.size(); i++){ //For each index in the sub array arr[index...end]

            //Swap the elements at indices index and i
            int t = (int)arr.get(index);
            //arr.get(index) = arr.get(i);
            arr.set(index,i);
            //arr.get(i) = t;
            arr.set(i,t);

            //Recurse on the sub array arr[index+1...end]
            permuteHelper(arr, index+1);

            //Swap the elements back
            t = (int)arr.get(index);
            //arr[index] = arr[i];
            arr.set(index,i);
            //arr[i] = t;
            arr.set(i,t);
        }
    }


}
