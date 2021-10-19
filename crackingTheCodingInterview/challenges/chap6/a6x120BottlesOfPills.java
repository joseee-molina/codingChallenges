package chap6;

public class a6x120BottlesOfPills {
    /**
     * PROBLEM: Given 20 bottles of pills, wfrom which 19 have 1.0 gram pills
     * and 1 has 1.1 gram pills, find the one that has 1.1 gram pills by using
     * the scale once. Note: the scale gives you a precise masurement.
     *
     */

    /**
     * The solution is really really cool. How many pills does a bottle have?
     * We don't know that fact, but what we know is that if we take a number
     * of pills from the exceeding bottle, we know that that exceeding is because
     * there was heavier pills there. So, in order to solve this problem, we can:
     * 1. Take 1 pill from bottle 1, 2 from bottle 2 and so on until the 20th
     * 2. Weigh the pills. The result of 1+2+...+20 should be 380, but there will
     * e an exceeding, how much is the exceeding /10 is the bottle that we are
     * looking for.
     */
}
