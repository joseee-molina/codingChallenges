package chap6;

public class a6x4AntsOnATriangle {
    /**
     * Three ants in the sides of a triangle walk in one direction, and they
     * choose direction randomly. What is the probability that there is a collision
     * of two or more ants?
     */

    /**
     * We just have two cases with no collisions, when they walk in the same direction
     * left or right. In total we have the following cases for the three ants choosing
     * L or R as directions:
     * LLL LLR LRL RLL LRR RRL RLR RRR
     *
     * So, the probability that they have one or more collisions is : 6/8 = 2/3
     */
}
