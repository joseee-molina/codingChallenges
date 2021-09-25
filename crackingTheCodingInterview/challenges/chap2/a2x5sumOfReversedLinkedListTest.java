package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a2x5sumOfReversedLinkedListTest extends a2x5sumOfReversedLinkedList {
    @Test
    public void test1(){

        DLListPublic dll1 = DLListPublic.of(7,1,6);
        DLListPublic dll2 = DLListPublic.of(5,9,2);
        assertEquals(sumOfReversedLinkedList(dll1,dll2).toString(), "2 1 9");

        DLListPublic dll3 = DLListPublic.of(8,4,2,1,2);
        DLListPublic dll4 = DLListPublic.of(9,2,3);
        assertEquals(sumOfReversedLinkedList(dll3,dll4).toString(), "7 7 5 1 2");

        DLListPublic dll5 = DLListPublic.of(1,5);
        DLListPublic dll6 = DLListPublic.of(1,6);
        assertEquals(sumOfReversedLinkedList(dll5,dll6).toString(), "2 1 1");

        DLListPublic dll7 = DLListPublic.of(5);
        DLListPublic dll8 = DLListPublic.of(6);
        assertEquals(sumOfReversedLinkedList(dll7,dll8).toString(), "1 1");

    }


}