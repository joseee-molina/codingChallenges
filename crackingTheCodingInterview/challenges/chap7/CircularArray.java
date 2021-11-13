package chap7;

import java.util.ArrayList;
import java.util.Iterator;

public class CircularArray <T> implements Iterable<T> {
    public int head;
    public ArrayList<T> arr;

    public CircularArray(){
        head =0;
        arr = new ArrayList<>();
    }

    public int convertHead(int shift){
        if(shift<0){
            shift+=arr.size();
        }
        return (head+shift)%arr.size();
    }

    public void rotate(int shiftRight){
        head = convertHead(shiftRight);
    }

    public T get(int i){
        if(i<0 || i>=arr.size()){
            throw new IndexOutOfBoundsException();
        }
        return arr.get(convertHead(i));
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
            return ind<arr.size()-1;
        }

        @Override
        public T next() {
            ind++;
            return (T) arr.get(convertHead(ind));
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }

}
