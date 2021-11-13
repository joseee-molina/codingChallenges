package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularArrayTest extends CircularArray {
    @Test
    public void test1(){
        CircularArray<Integer> a = new CircularArray(2);
        a.set(0,1);
        a.set(1,2);
        for(int i : a){
            System.out.println(i);
        }
    }


}