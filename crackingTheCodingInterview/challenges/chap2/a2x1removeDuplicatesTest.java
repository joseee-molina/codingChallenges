package chap2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

class a2x1removeDuplicatesTest extends a2x1removeDuplicates {

    @Test
    public void test1(){
        DLList dll = DLList.of(1,2,5,3,2,1,4);
        removeDuplicatesFromLinkedList(dll).toString();
    }
}