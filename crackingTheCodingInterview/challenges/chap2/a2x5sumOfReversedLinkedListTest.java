package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a2x5sumOfReversedLinkedListTest extends a2x5sumOfReversedLinkedList {
    @Test
    public void test1(){

        DLListPublic dll1 = DLListPublic.of(7,1,6);
        DLListPublic dll2 = DLListPublic.of(5,9,2);

        System.out.println(sumOfReversedLinkedList(dll1,dll2));

    }


}