package chap3;

import java.util.Comparator;
import java.util.Stack;

public class a3x5SortAStackUsingTwoStacks {

    public Stack sortStack(Stack stack) {

        Stack helperStack = new Stack<>();

        while (!stack.isEmpty()) {
            helperStack.push(findStackMaximum(stack));
        }

        return helperStack;
    }

    public int findStackMaximum(Stack<Integer> stack){
        Stack helper = new Stack();
        int max = Integer.MIN_VALUE;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            max = curr>max ? curr : max;
            helper.push(curr);
        }
        fillStackAwithStackB(stack, helper, max);
        return max;
    }

    public void fillStackAwithStackB(Stack<Integer> a, Stack<Integer> b, int except){
        boolean excluded = false;
        while(!b.isEmpty()){
            int curr = b.pop();
            if(curr==except && excluded==false){
                excluded= true;
                continue;
            }
            a.push(curr);
        }
    }

    public void printStack(Stack<Integer> stack){

        Stack<Integer> helper = new Stack<>();

        while (!stack.isEmpty()){
            int curr = stack.pop();
            System.out.println(curr);
            helper.push(curr);
        }
        while(!helper.isEmpty()){
            stack.push(helper.pop());
        }

    }


}
