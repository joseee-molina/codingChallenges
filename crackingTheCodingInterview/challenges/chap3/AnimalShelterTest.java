package chap3;

import chap2.DLListPublic;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalShelterTest extends AnimalShelter {
    @Test
    public void removeLastDLLPublicTest(){
        DLListPublic<Integer> dll = DLListPublic.of(1,2,3,4,5,6);
        dll.removeLast();
        System.out.println(dll.toString());
        dll.removeFirst();
        System.out.println(dll.toString());
        dll.removeFirst();
        dll.removeFirst();
        dll.removeFirst();
        dll.removeFirst();
        dll.removeFirst();
        dll.removeFirst();
    }
    
    @Test
    public void AnimalShelterTest(){

    }
}