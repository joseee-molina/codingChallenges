import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class a1x5OneModificationAwayTest extends a1x5OneModificationAway {
    @Test
    public void test1(){
        assertTrue(areOneAway("pale", "ple"));
        assertTrue(areOneAway("pales","pale"));
        assertTrue(areOneAway("pale", "bale"));
        assertFalse(areOneAway("pale","bake"));
    }
}