import org.junit.Test;
import static org.junit.Assert.*;

class a1x2isStringPermutationOfTheOtherTest extends a1x2isStringPermutationOfTheOther {
    @Test
    public void test(){
        assertTrue(isPermutation("abcd", "badce"));
    }
}