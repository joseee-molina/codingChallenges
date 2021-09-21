package chap2;


import java.util.HashSet;
import java.util.LinkedList;

public class a2x1removeDuplicates<Item> extends DLList{
    public static DLList removeDuplicatesFromLinkedList(DLList dll){
        HashSet<Integer> set = new HashSet<>();
        Node pointer = dll.sentinel.next;
        while(pointer!= dll.sentinel){
            int i = (int) pointer.item;
            if(set.contains(i)){
                pointer.prev.next = pointer.next;
                pointer.next.prev = pointer.prev;
            }
            pointer = pointer.next;
        }
        return dll;
    }
}
