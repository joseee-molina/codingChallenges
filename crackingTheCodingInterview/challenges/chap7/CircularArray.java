package chap7;

import java.util.ArrayList;

public class CircularArray <T> {
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
}
