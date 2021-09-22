package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DLListTest2x2 extends DLList {
    @Test
    public void test1(){
        DLList dll = DLList.of(1,1,2,3,4,4,3,2,7,5,9);
        assertEquals(5,dll.returnKthToLast(2));
        //dll.returnKthToLast(143);
        //exception working
    }

}