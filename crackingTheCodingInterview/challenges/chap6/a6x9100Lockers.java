package chap6;

import java.util.ArrayList;

public class a6x9100Lockers {
    /**
     * There are 100 Lockers. A man first opens all of them, then in the second
     * pass, he opens every 2, then in the 3rd pass every 3, and so on. If a
     * locker is already opened, he closes it. At the end, how many lockers are open?
     *
     */

    /**
     * We can solve this using an array of 100 and then changing to true or false
     * depending on if the number is divisible by 1,2,3,4,... and so on up to 100.
     * And that is what I will do.
     *
     */

    public ArrayList getLockersAfterTogglingInFunnyWay(int n){
        /**
         * I added an n so that it will work for every number now
         */

        ArrayList<Boolean> arr = new ArrayList<>();
        fillArrayfromAtoB(1,100,arr);
        toggleArray(arr);
        return arr;
    }

    public void fillArrayfromAtoB(int A, int B, ArrayList arr){
        for(int i=A; i<=B; i++){
            arr.add(i);
        }
    }

    public void toggleArray(ArrayList<Boolean> arr){
        for(int i = 1 ; i<arr.size();i++){
            for(int j = 1; j<arr.size();i++){
                if(j%i==0){
                    arr.set(j,!arr.get(j));
                }
            }
        }

    }
}
