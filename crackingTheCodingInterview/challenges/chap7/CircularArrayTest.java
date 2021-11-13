package chap7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularArrayTest extends CircularArray {
    @Test
    public void test1(){
        CircularArray a = new CircularArray(5);
        for(Object o : a){
            System.out.println(o.toString());
        }
    }


}