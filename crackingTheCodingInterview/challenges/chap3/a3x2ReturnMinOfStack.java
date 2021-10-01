package chap3;

public class a3x2ReturnMinOfStack {
    /**
     * How would you design a stack that can do pop, push, peek and also return the min element?
     * Well first i thought of just having a min element that can be the min, and update it as
     * we insert more elements, which can be done in constant time, however, when we pop elements
     * it will be hard to keep track of the other minimums (can be done in linear time if we scan
     * through the linked list implementation of the stack) Can we do better?
     * Yes, by using a min heap! It can insert elements in log(n) time, but for sure that will
     * return the minimum value in constant time. Other than the heap, we also need the linked list
     * to keep track of the stack, so the pop and push would be done in log(N), and the return min
     * would be done in constant time
     *
     * However, that is NOT constant time as expected
     *
     * the best i can do is linear time? Well, I can have a min element that, whenever you push,
     * it updates in linear time, but when you pop? that will be linear time if you wanna find out
     * the min there. Is there a better way to do this?
     *
     * What if, every time that you call min after popping, you build the heap I really don't know
     *
     *
     *
     */
}
