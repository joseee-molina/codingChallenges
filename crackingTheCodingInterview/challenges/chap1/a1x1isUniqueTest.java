package chap1;

import chap1.a1x1isUnique;
import org.junit.Test;
import static org.junit.Assert.*;

public class a1x1isUniqueTest extends a1x1isUnique {
    @Test
    public void testOne(){
        assertTrue(hasUniqueChars("abcs"));
    }
}