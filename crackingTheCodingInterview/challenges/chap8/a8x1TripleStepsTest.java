package chap8;

import org.junit.Test;

import static org.junit.Assert.*;

public class a8x1TripleStepsTest extends a8x1TripleSteps {
    @Test
    public void test1(){
        System.out.println(countNumberOfWays(1));
        System.out.println(countNumberOfWays(2));
        System.out.println(countNumberOfWays(3));
        System.out.println(countNumberOfWays(4));
        System.out.println(countNumberOfWays(5));
    }

}