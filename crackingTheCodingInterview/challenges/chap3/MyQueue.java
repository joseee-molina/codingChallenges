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
}
