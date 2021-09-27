package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a2x7checkIntersectionOfTwoLinkedListsTest extends a2x7checkIntersectionOfTwoLinkedLists {
    @Test
    public void test1(){
        DLListPublic dll1 = DLListPublic.of(1,2,3);
        DLListPublic dll2 = DLListPublic.of(2,4);
        dll2.sentinel.prev = dll1.sentinel.next;
        checkIntersection(dll1,dll2);
    }
}