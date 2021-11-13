package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularArrayTest extends CircularArray {
    @Test
    public void test1(){
        CircularArray<Integer> a = new CircularArray(3);
        a.set(0,1);
        a.set(1,2);
        a.set(2,3);
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
        a.rotate(1);
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
        // test finished

    }


}