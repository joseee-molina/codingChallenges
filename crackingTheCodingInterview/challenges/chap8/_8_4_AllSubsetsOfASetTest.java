package chap8;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class _8_4_AllSubsetsOfASetTest extends _8_4_AllSubsetsOfASet {
    @Test
    public void test1(){
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        printAllSubsetsOfSet(set1);
        //it worked!!
    }

}