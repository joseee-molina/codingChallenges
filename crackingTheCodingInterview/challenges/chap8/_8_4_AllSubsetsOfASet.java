package chap8;

import java.util.ArrayList;
import java.util.HashSet;

public class _8_4_AllSubsetsOfASet {
    /**
     * This is recursive:
     * A set of N elements has 2^N subsets, so, essentially, we need to compute
     * all possible permutations of the elements in the set for length 1,2,...,N
     * and those permutations will be n
     * The base case is the empty and the 1 element set:
     * if set empty, the subset is itself,
     * if set 1 element, the subsets is the empty and the itself
     */

    public void printAllSubsetsOfSet(HashSet<Integer> set){
        ArrayList setArr = new ArrayList();
        for(int x : set) {
            setArr.add(x);
        }

    }
    public void printSubset(int[] subset){
        for(int x:subset){
            if(x!=Integer.MIN_VALUE){
                System.out.print(x+" ");
            }
        }
    }

    private void subsetsHelper(ArrayList<Integer> set, int[] subset, int index){
        if(index==set.size()){
            printSubset(subset);
            System.out.println();
        }
        subset[index] = Integer.MIN_VALUE;
        subsetsHelper(set,subset,index+1);
        subset[index] = set.get(index);
        subsetsHelper(set,subset,index+1);

    }

}
