import org.junit.Test;
import static org.junit.Assert.*;

public class a1x2isStringPermutationOfTheOtherTest extends a1x2isStringPermutationOfTheOther {
    @Test
    public void test1(){
        assertTrue(isPermutation("abcd", "badc"));

    }
    @Test
    public void test2(){
        assertTrue(stringPermutationConstantSolution("abcd","bcad"));
    }

}