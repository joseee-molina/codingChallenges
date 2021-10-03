package chap3;

import java.util.*;

public class MyQueue<T> {

    /**
     * Implementation of a queue using two stacks
     * we can add in constant time, but when we need to pop or peek, we need to pass everything
     * to the other stack so that we can see the bottom elemeent which is the front, and so that
     * it appears top of the stack, and the last top now is a bottom
     *
     *
     */

    public Stack<T> fillingStack;
    public Stack<T> flippingStack;

    public MyQueue(){
        fillingStack=new Stack<>();
        flippingStack = new Stack<>();
    }

    public void add(T item){
        fillingStack.add(item);
    }

    public T poll(){
        fillFlippingStack();
        T result = flippingStack.pop();
        fillFillingStack();
        flippingStack = new Stack<>();
        return result;
    }

    public T peek(){
        fillFlippingStack();
        T result = flippingStack.peek();
        fillFillingStack();
        flippingStack=new Stack<>();
        return result;
    }

    public void fillFlippingStack(){
        while(!fillingStack.isEmpty()){
            flippingStack.push(fillingStack.pop());
        }
    }

    public void fillFillingStack(){
        while(!flippingStack.isEmpty()){
            fillingStack.push(flippingStack.pop());
        }
    }

}
