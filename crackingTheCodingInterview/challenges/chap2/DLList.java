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


}


