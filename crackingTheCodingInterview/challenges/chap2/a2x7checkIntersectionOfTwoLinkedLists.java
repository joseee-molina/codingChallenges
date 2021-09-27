package chap2;

public class a2x7checkIntersectionOfTwoLinkedLists extends DLListPublic {
    public Node checkIntersection(DLListPublic dll1, DLListPublic dll2){

        Node ptr1 = dll1.sentinel.next;
        Node ptr2 = dll2.sentinel.next;
        Node temp;
        while(ptr1!=dll1.sentinel){
            temp = ptr1;
            ptr2 = dll2.sentinel.next;
            while(ptr2!=dll2.sentinel){
                if(ptr1==ptr2){
                    return ptr1;
                }
                ptr2=ptr2.next;
            }
            ptr1 = temp.next;
        }
        return null;
    }
}
