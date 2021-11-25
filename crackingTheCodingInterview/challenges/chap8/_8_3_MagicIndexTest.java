package chap8;

import org.junit.Test;

import static org.junit.Assert.*;

public class _8_3_MagicIndexTest extends _8_3_MagicIndex {
    @Test
    public void test1(){
        int[] arr1 = {0,2,3,4,5,6,7,8,9,10,11,12,13,20};
        System.out.println(findMagicIndex(arr1));
    }

}