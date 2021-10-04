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
        public Cat(){

        }
    }
    public class Dog extends Animal{
        public Dog(){

        }
    }

    public DLListPublic<Animal> shelterList;


    public AnimalShelter(){
        shelterList = new DLListPublic<>();

    }

    public Animal dequeueAny(){
        return shelterList.removeLast();
    }

    public void push(Animal a){
        shelterList.addFirst(a);
    }

    public Animal dequeueDog(){
        Node ptr = sentinel.prev;
        while(!ptr.item.getClass().equals(Dog.class)){
            ptr = ptr.prev;
            if(ptr.equals(shelterList.sentinel)){
                throw new IndexOutOfBoundsException();
            }
        }
        return (Dog) ptr.item;
    }

    public Animal dequeueCat(){
        Node ptr = sentinel.prev;
        while(!ptr.item.getClass().equals(Cat.class)){
            ptr = ptr.prev;
            if(ptr.equals(shelterList.sentinel)){
                throw new IndexOutOfBoundsException();
            }
        }
        return (Cat) ptr.item;
    }

}
