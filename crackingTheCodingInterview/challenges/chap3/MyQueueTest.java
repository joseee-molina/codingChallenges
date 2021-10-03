package chap3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest extends MyQueue {

    @Test
    public void test1(){
        MyQueue<Integer> mq = new MyQueue<>();
        mq.add(1);
        mq.add(2);
        mq.add(3);
        System.out.println(mq.poll());
        mq.add(4);
        System.out.println(mq.poll());
        System.out.println(mq.peek());
        System.out.println(mq.poll());
        System.out.println(mq.poll());
    }
}