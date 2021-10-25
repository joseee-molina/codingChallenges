package chap6;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class a6x9100LockersTest extends a6x9100Lockers {
    @Test
    public void test1(){
        ArrayList<Boolean> arr = getLockersAfterTogglingInFunnyWay(100);
        for(int i = 0 ; i<arr.size();i++){
            if(arr.get(i)==true){
                System.out.println(i);
            }
        }
        /**
         * So, the answer are the squares, but how?
         * I think it is because these numbers all have an even number
         * of prime factors, which make it just open and not closed.
         * Yeah, it makes senese
         */
    }
}