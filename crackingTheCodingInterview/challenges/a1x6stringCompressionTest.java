import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x6stringCompressionTest extends a1x6stringCompression {
    @Test
    public void test1(){
        assertEquals(compressString("aabcccccaaa"),"a2b1c5a3");
        //it's working wow
        System.out.println(compressString("aabcccccaaa"));
        assertEquals(compressString("abc"), "abc");
        //how to make more efficient?
        //maybe count the number of different chunks of characters
        //and then see if that number times 2 is less than the length of the string
    }
}