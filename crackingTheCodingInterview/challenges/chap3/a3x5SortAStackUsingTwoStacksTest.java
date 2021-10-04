package chap3;

import org.junit.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class a3x5SortAStackUsingTwoStacksTest extends a3x5SortAStackUsingTwoStacks {
    @Test
    public void test1(){

        Stack<Integer> stack1 = new Stack<>();
        stack1.push(2);
        stack1.push(1);
        stack1.push(5);
        stack1.push(2);
        stack1.push(7);
        stack1.push(6);
        stack1.push(3);
        Stack<Integer> stack2 = sortStack(stack1);
        printStack(stack2);

    }

}