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
        AnimalShelter shelter = new AnimalShelter();
        Dog d1 = new Dog(1);
        Dog d2 = new Dog(2);
        Dog d3 = new Dog(3);
        Dog d4 = new Dog(4);
        Dog d5 = new Dog(5);
        Cat c1 = new Cat(1);
        Cat c2 = new Cat(2);
        Cat c3 = new Cat(3);
        Cat c4 = new Cat(4);
        Cat c5 = new Cat(5);
        Cat c6 = new Cat(6);

        shelter.push(d1);
        System.out.println("Added : "+d1);
        shelter.push(c6);
        System.out.println("Added : "+c6);
        shelter.push(d4);
        System.out.println("Added : "+d4);
        shelter.push(d3);
        System.out.println("Added : "+d3);
        shelter.push(c3);
        System.out.println("Added : "+c3);
        shelter.push(c1);
        System.out.println("Added : "+c1);

        shelter.dequeueAny();
        shelter.dequeueDog();
        shelter.dequeueDog();
        shelter.dequeueCat();
        shelter.dequeueCat();

    }
}