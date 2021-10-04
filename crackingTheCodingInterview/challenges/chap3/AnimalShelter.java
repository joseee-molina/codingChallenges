package chap3;

import chap2.DLList;
import chap2.DLListPublic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class AnimalShelter extends DLListPublic {
    public class Animal{

        public Animal(){

        }
    }
    public class Cat extends Animal{
        public int id;
        public Cat(int n){
            id = n;
        }
    }
    public class Dog extends Animal{
        public int id;
        public Dog(int n){
            id = n;
        }
    }

    public DLListPublic<Animal> shelterList;


    public AnimalShelter(){
        shelterList = new DLListPublic<>();

    }

    public Animal dequeueAny(){
        Animal a = shelterList.removeLast();
        System.out.println("ANimal :"+ a.toString());
        return a;
    }

    public void push(Animal a){
        shelterList.addLast(a);
    }

    public Dog dequeueDog(){
        Node ptr = shelterList.sentinel.prev;
        while(!ptr.item.getClass().equals(Dog.class)){
            ptr = ptr.prev;
            if(ptr.equals(shelterList.sentinel)){
                throw new IndexOutOfBoundsException();
            }
        }
        ptr.prev.next = ptr.next;
        ptr.next.prev = ptr.prev;
        System.out.println("Dog: "+ (Dog) ptr.item);
        return (Dog) ptr.item;
    }

    public Animal dequeueCat(){
        Node ptr = shelterList.sentinel.prev;
        while(!ptr.item.getClass().equals(Cat.class)){
            ptr = ptr.prev;
            if(ptr.equals(shelterList.sentinel)){
                throw new IndexOutOfBoundsException();
            }
        }
        ptr.prev.next = ptr.next;
        ptr.next.prev = ptr.prev;
        System.out.println("Cat: "+ (Cat) ptr.item);

        return (Cat) ptr.item;
    }

}
