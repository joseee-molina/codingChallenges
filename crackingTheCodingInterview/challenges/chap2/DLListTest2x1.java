package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DLListTest2x1 extends DLList {
    @Test
    public void test1(){
        DLList dll = DLList.of(1,2,3,2,4,4,5,11);
        dll.removeDuplicatesFromLinkedList();
        System.out.println(dll.toString());
        //another test
        DLList dll2 = DLList.of(1,1,1,1,1,2);
        dll2.removeDuplicatesFromLinkedList();
        System.out.println(dll2.toString());
    }
}