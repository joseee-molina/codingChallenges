package chap1;

import chap1.a1x3replaceSpacesURLify;
import org.junit.Test;
import static org.junit.Assert.*;


public class a1x3replaceSpacesURLifyTest extends a1x3replaceSpacesURLify {
    @Test
    public void test1(){
        char[] a = {'a', ' ' , 'c', ' ', 'x',' ',' ', ' ',' '};
        char[] b = {'a', '%' , '2', '0', 'c','%','2', '0','x'};
        assertArrayEquals(b,replaceSpaces(a));
    }



}