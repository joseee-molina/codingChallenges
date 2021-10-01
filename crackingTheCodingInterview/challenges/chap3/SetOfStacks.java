package chap3;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks<T> {
    public ArrayList<Stack> stackList;
    public int currentStack;
    public int threshold;

    public SetOfStacks(int threshold){
        currentStack = 0 ;
        stackList = new ArrayList<>();
        stackList.add(new Stack());
        this.threshold = threshold;
    }

    public SetOfStacks(){
        currentStack = 0 ;
        stackList = new ArrayList<>();
        stackList.add(new Stack());
        this.threshold = 5;
    }

    public void push(T item){
        stackList.get(currentStack).push(item);
        if(stackList.get(currentStack).size()> threshold){
            stackList.add(new Stack());
            currentStack++;
        }
    }

    public T pop(){
        T item = (T) stackList.get(currentStack).pop();
        if(stackList.get(currentStack).isEmpty() && currentStack>0){
            currentStack--;
        }
        return item;
    }

}
