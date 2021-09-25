package chap2;

import java.util.LinkedList;

public class a2x5sumOfReversedLinkedList extends DLListPublic<Integer> {

    public static DLListPublic sumOfReversedLinkedList(DLListPublic ll1, DLListPublic ll2){
        Node ptr1 = ll1.sentinel.next;
        Node ptr2 = ll2.sentinel.next;
        int llevamos = 0 ;
        int currSum = 0 ;
        int toAdd = 0;
        DLListPublic result = new DLListPublic();
        while(ptr1 != ll1.sentinel && ptr2 != ll2.sentinel){
            currSum = ptr1.item+ptr2.item;
            toAdd = (currSum+llevamos)%10 ;
            llevamos = (currSum+llevamos)/10;
            result.addLast(toAdd);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        if(ptr1== ll1.sentinel){
            while(ptr2 != ll2.sentinel){
                toAdd = (ptr2.item+llevamos)%10 ;
                llevamos = (ptr2.item+llevamos)/10;
                result.addLast(toAdd);
                ptr2 = ptr2.next;
            }
        }
        if(ptr2== ll2.sentinel){
            while(ptr1 != ll1.sentinel){
                toAdd = (ptr1.item+llevamos)%10 ;
                llevamos = (ptr1.item+llevamos)/10;
                result.addLast(toAdd);
                ptr1 = ptr1.next;
            }
        }
        if(llevamos!=0){
            result.addLast(llevamos);
        }
        return result;
    }

}
