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
    public void palindromeFirstMethodTest(){
        DLList dll = DLList.of(1,2,3,3,2,1);
        assertTrue(dll.checkIfLinkedListIsPalindromeDoublyLinkedList());
        DLList dll2 = DLList.of(1,2,1);
        assertTrue(dll2.checkIfLinkedListIsPalindromeDoublyLinkedList());
        dll2.addLast(1);
        assertFalse(dll2.checkIfLinkedListIsPalindromeDoublyLinkedList());
    }

    @Test
    public void palindromeSecondMethodTest(){
        DLList dll = DLList.of(1,2,3,4,3,2,1);
        assertTrue(dll.checkIfLinkedListIsPalindromeSinglyLinkedList());
        DLList dll2 = DLList.of(1,2,3,3,2,1);
        assertTrue(dll2.checkIfLinkedListIsPalindromeSinglyLinkedList());
        dll2.addLast(2);
        dll2.addLast(1);
        assertFalse(dll2.checkIfLinkedListIsPalindromeSinglyLinkedList());
    }
}