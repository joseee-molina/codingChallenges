package chap3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetOfStacksTest extends SetOfStacks {

    @Test
    public void test1(){
        SetOfStacks<Integer> set =  new SetOfStacks<>(3);
        for (int i = 0; i<11; i++){
            set.push(i);
        }
        for(int i = 0 ; i<11; i++){
            System.out.println(set.pop());
        }
        for (int i = 0; i<11; i++){
            set.push(i);
        }
        for(int i = 0 ; i<11; i++){
            System.out.println(set.pop());
        }
        /**
         * It's working fine!!!
         */

    }
}