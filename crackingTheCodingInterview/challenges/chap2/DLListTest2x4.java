package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DLListTest2x4 extends DLList {
    @Test
    public void test1(){
        DLList dll = DLList.of(10,4,6,3,5,8,5,10,2,1,1);
        System.out.println(dll.toString());
        dll.partition(5);
        System.out.println(dll.toString());
        DLList dll2 = DLList.of(1,2,0);
        dll.partition(1);
        System.out.println(dll2.toString());
    }
}