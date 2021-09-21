package chap1;

import chap1.a1x4PalindromePermutation;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class a1x4PalindromePermutationTest extends a1x4PalindromePermutation {
    @Test
    public void test1(){
        assertTrue(isPermutationOfAPalindrome("Tact Coa"));
    }
    @Test
    public void test2(){
        assertTrue(isPermutationOfAPalindrome("Tact xCoax"));
    }
}