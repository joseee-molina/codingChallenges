package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DLListTest2x3 extends DLList {
    @Test
    public void test1(){
        DLList dll = DLList.of(1,2,3,4,5);
        dll.remoreMiddleElement();
        System.out.println(dll);
        dll.remoreMiddleElement();
        System.out.println(dll);
    }

}