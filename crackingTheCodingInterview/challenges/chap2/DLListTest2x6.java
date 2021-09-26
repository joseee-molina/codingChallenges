package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DLListTest2x6 extends DLList {
    @Test
    public void getTest(){
        //first let's test the get again
        DLList dll = DLList.of(1,2,3,4,5,6);
        assertEquals(dll.get(1),2);
        assertEquals(dll.get(dll.size()-1),6);
        //ok its working
    }

    @Test
    

}