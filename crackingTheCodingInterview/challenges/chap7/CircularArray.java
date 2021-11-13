package chap7;

import java.util.ArrayList;
import java.util.Iterator;

public class CircularArray <T> implements Iterable<T> {
    public int head;
    public T[]arr;

    public CircularArray(){
        head=0;
        arr= (T[])new Object[0];
    }

    public CircularArray(int size){
        head =0;
        arr = (T[]) new Object[size];
    }

    public int convertHead(int shift){
        if(shift<0){
            shift+=arr.length;
        }
        if(head==0 && shift ==0){
            return 0;
        }
        return (head+shift)%arr.length;
    }

    public void rotate(int shiftRight){
        head = convertHead(shiftRight);
    }

    public T get(int i){
        if(i<0 || i>=arr.length){
            throw new IndexOutOfBoundsException();
        }
        return arr[convertHead(i)];
    }

    public void set(int index, T el){
        arr[convertHead(index)] = el;
    }

    /**
     * In order to iterate using for(Object o : arr){},
     * we need to implement an iterator
     */
    public Iterator<T> iterator(){
        return new CircularArrayIterator<T>();
    }

    private class CircularArrayIterator<T> implements Iterator<T>{
        private int ind = -1;

        public CircularArrayIterator(){
        }

        @Override
        public boolean hasNext() {
            return ind<arr.length-1;
        }

        @Override
        public T next() {
            ind++;
            return (T) arr[convertHead(ind)];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }

}
