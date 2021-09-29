package chap3;

public class a3x1ThreeStacksInOneArray {
    /**
     * To do 3 stacks in 1 array I would divide it in 3 equal parts,
     * and then have pointers to the top of each stack, one beginning at
     * index i = 0 , other at i = length/3, and other at 2*length/3
     * then they would move as i fill the stacks and when some of them is full,
     * i would just resize the array and make it 3 times bigger and then copy the elements there
     * i think it would be a good solution and it would be pretty efficient, you can add and remove
     * elements in constant time, except when you need to resize
     * however, lets suppose you resize every 3n sizes, then you can distribute those into different
     * buckets and then it would still be constant time.
     *
     * If someone sees this, i hope you have suggestions or thoughts about it!
     *
     */
}
