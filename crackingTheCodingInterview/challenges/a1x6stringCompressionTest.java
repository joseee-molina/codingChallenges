import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x6stringCompressionTest extends a1x6stringCompression {
    @Test
    public void test1(){
        assertEquals(compressString("aabcccccaaa"),"a2b1c5a3");
        //
        System.out.println(compressString("aabcccccaaa"));
        assertEquals(compressString("abc"), "abc");
    }
}