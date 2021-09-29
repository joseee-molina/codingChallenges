package chap2;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a2x8LoopStartingPointTest extends a2x8LoopStartingPoint {
    @Test
    public void test1(){
        DLListPublic dll = DLListPublic.of(2,1,2,3,4);
        dll.sentinel.prev.next = dll.sentinel.next.next;
        System.out.println(loopStartHere(dll).item);
        loopStartHere(dll);
        //am i on an infinite loop? The visualizer is not working?
    }

}