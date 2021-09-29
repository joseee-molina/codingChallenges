package chap2;

import java.util.HashSet;

public class a2x8LoopStartingPoint extends DLListPublic{

    public Node loopStartHere(DLListPublic dll){

        if(!hasALoop(dll)){
            return null;
        }

        HashSet<Node> nodesSet = new HashSet<>();
        Node ptr = dll.sentinel.next;

        while(true){
            if(nodesSet.contains(ptr)){
                return ptr;
            }
            nodesSet.add(ptr);
            ptr = ptr.next;
        }
    }
    public boolean hasALoop(DLListPublic dll){
        Node slowPtr = dll.sentinel.next;
        Node fastPtr = dll.sentinel.next;
        while(fastPtr!=sentinel){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr==fastPtr){
                return true;
            }
        }
        return false;
    }
}
