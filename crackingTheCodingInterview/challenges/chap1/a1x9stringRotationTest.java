package chap1;

import static org.junit.jupiter.api.Assertions.*;

import chap1.a1x9stringRotation;
import org.junit.Test;

public class a1x9stringRotationTest extends a1x9stringRotation {
    @Test
    public void test1(){
        assertTrue(isStringRotation("mypencil","encilmyp"));
        //passed the test
        assertFalse(isStringRotation("abcde","abcdf"));
        assertFalse(isStringRotation("abcde","abcd"));
        //passed these tests
    }
}