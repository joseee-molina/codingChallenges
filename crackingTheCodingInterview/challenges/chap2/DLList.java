package chap2;
import java.util.HashSet;
import java.util.Iterator;


/**
 * A DLList is a list of integers. Like SLList, it also hides the terrible
 * truth of the nakedness within, but with a few additional optimizations.
 */
public class DLList<Item> implements Iterable<Item> {
    //TODO Node Should be private class Node, but to make it easier to import and use, I will leave it like this
    //
    //OJO:
    private class Node {
        public Node prev;
        public Item item;
        public Node next;

        public Node(Item i, Node p, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    //TODO: these two should also be private
    private Node sentinel;
    private int size;

    /** Creates an empty DLList. */
    public DLList() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Returns a DLList consisting of the given values. */
    public static <Item> DLList<Item> of(Item... values) {
        DLList<Item> list = new DLList<>();
        for (Item value : values) {
            list.addLast(value);
        }
        return list;
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Adds item to the back of the list. */
    public void addLast(Item item) {
        Node n = new Node(item, sentinel.prev, sentinel);
        n.next.prev = n;
        n.prev.next = n;
        size += 1;
    }

    public void addFirst(Item item){
        Node n = new Node (item, sentinel, sentinel.next);
        n.prev.next = n;
        n.next.prev = n;
        size++;
    }

    @Override
    public String toString() {
        String result = "";
        Node p = sentinel.next;
        boolean first = true;
        while (p != sentinel) {
            if (first) {
                result += p.item.toString();
                first = false;
            } else {
                result += " " + p.item.toString();
            }
            p = p.next;
        }
        return result;
    }

    /** Returns whether this and the given list or object are equal. */
    public boolean equals(Object o) {
        DLList other = (DLList) o;
        if (size() != other.size()) {
            return false;
        }
        Node op = other.sentinel.next;
        for (Node p = sentinel.next; p != sentinel; p = p.next) {
            if (!(p.item.equals(op.item))) {
                return false;
            }
            op = op.next;
        }
        return true;
    }

    public Iterator<Item> iterator() {
        return new DLListIterator();
    }

    private class DLListIterator implements Iterator<Item> {
        private Node bookmark = sentinel.next;

        public Item next() {
            Item returningItem = bookmark.item;
            bookmark = bookmark.next;
            return returningItem;
        }

        public boolean hasNext() {
            return bookmark.item != null;
        }
    }


    //-------- 2-1 remove duplicates of LinkedList
    public void removeDuplicatesFromLinkedList(){
        HashSet<Integer> set = new HashSet<>();
        Node pointer = sentinel.next;
        while(pointer!= sentinel){
            int i = (int) pointer.item;
            if(set.contains(i)){
                pointer.prev.next = pointer.next;
                pointer.next.prev = pointer.prev;
            }
            set.add(i);
            pointer = pointer.next;
        }
    }

    //--------- 2-2 return Kth to Last
    public Item returnKthToLast(int k){
        if(k>size){
            throw new IndexOutOfBoundsException();
        }
        Node pointer = sentinel.next;
        int index = 0;
        while(index!=size-k){
            pointer=pointer.next;
            index++;
        }
        return pointer.item;
    }

    //---------- 2-3 remove middle element in the list
    public void remoreMiddleElement(){
        Node head = sentinel.next;
        int index = 0;
        int middleNum = size()%2==1 ? size()/2 -1 : size()/2 -2;
        while(index<middleNum){
            head=head.next;
            index++;
        }
        head.next = head.next.next;
        head.next.prev = head;
        size--;
    }
    //-------- 2-4 partition arount X: all elements less than x must come before all greater than or
    //equal to x

    public void partition(int partitionElement){
        //I want to do this in O(N) time and O(1) space, so I will basically relocate the nodes
        //This algorithm will have two parts, the first will be relocating the bigger to the right
        //and thr second will be relocating the smaller to the left
        relocate(partitionElement);
    }

    public void relocate(int partitionElement){
        Node ptr = sentinel;

        while(ptr == sentinel || !ptr.item.equals(partitionElement)){
            if((int) ptr.next.item > partitionElement){
                addLast(ptr.next.item);
                ptr.next = ptr.next.next;
                ptr.next.prev = ptr;

            }
            ptr=ptr.next;
        }
        while(ptr.next!=sentinel){
            if((int) ptr.next.item < partitionElement){
                addFirst(ptr.next.item);
                ptr.next = ptr.next.next;
                ptr.next.prev = ptr;
                ptr=ptr.prev;
                continue;
            }
            ptr=ptr.next;
        }
    }

    public boolean checkIfLinkedListIsPalindromeDoublyLinkedList(){

        //CASE 1: Doubly linked list
        //Having a beginning and last pointer, and checking if the elements are equal as we
        //make them closer to the middle
        //O(N) time, O(1) space

        Node firstPointer = sentinel.next;
        int firstIndex = 0 ;
        int lastIndex = size-1 ;
        Node lastPointer = sentinel.prev;

        while(firstIndex<lastIndex){
            if(firstPointer.item!=lastPointer.item){
                return false;
            }
            firstPointer=firstPointer.next;
            lastPointer = lastPointer.prev;
            firstIndex++;
            lastIndex--;
        }
        return true;
    }
    public Item get(int index) {
        /**
         * Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
         * If no such item exists, returns null. Must not alter the deque!
         */
        if (size == 0) {
            return null;
        }
        Node p = sentinel.next;
        int n = 0;
        while (n < index) {
            if (p.next == sentinel) {
                throw new IllegalArgumentException("index grater than size of List");
            }
            p = p.next;
            n++;
        }
        return p.item;
    }

    public boolean checkIfLinkedListIsPalindromeSinglyLinkedList(){
        //We can do in O(N^2) time and O(1) space or O(N) time and O(N) space

        //First solution is just passing linkedist to array and doing first solution.
        //Second, is by traversing the whole list for every node

        int index = 0 ;
        Node ptr1 = sentinel.next;
        while (index<=size/2){
            if(ptr1.item != get(size-1-index)){
                return false;
            }
            ptr1 = ptr1.next;
            index++;
        }
        return true;
    }

}


