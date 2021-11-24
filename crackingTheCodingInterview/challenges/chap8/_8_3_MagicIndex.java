package chap8;

public class _8_3_MagicIndex {
    /*
    Given an array arr of sorted integers, find the index i where a[i] = i

    There is of course a way to know this in O(N) time, but I'd rather do
    the binary search like this:
    1. Find the number in the middle, if it is the magic index then we finished, if it
    is:
    - GREATER than the index, it means that everything above it is greater, so we need
    to check the first hand.
    - LOWER, then it means that everything before it is lower than the indexes, so we
    need to check the second half, and so on.

    Doing this binary search will take us log(N) time to implement
     */
}
