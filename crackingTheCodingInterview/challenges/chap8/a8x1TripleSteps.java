package chap8;

public class a8x1TripleSteps {
    //sunday 21 nov 2021 starting the chapter 8
    /*
    Given n stairs, count how many times you can go down the staircase
    taking one, two or three steps at a time
    base case: n=1 where count = 1
     */

    public int countNumberOfWays(int n){
        if(n==0){
            return 0;
        }
        return countStairwayWaysHelper(n);
    }

    public int countStairwayWaysHelper(int n){
        if(n==1 || n==0){
            return 1;
        }
        if(n>=3){
            return countStairwayWaysHelper(n-1) + countStairwayWaysHelper(n-2) + countStairwayWaysHelper(n-3);
        }
        if(n>=2){
            return countStairwayWaysHelper(n-1) + countStairwayWaysHelper(n-2);
        }
        if(n>=1){
            return countStairwayWaysHelper(n-1);
        }
        return 0;
    }
}
