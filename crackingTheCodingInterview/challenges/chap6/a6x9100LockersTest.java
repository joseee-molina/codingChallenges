package chap6;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class a6x9100LockersTest extends a6x9100Lockers {
    @Test
    public void test1(){
        ArrayList arr = getLockersAfterTogglingInFunnyWay(100);
        System.out.println(arr);
    }
}