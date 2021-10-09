package chap4;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
public class BinaryTree<T> {

    public TreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(TreeNode<T> t) {
        root = t;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    /* Returns the height of the tree starting from a node. */
    public int height(TreeNode n) {
        // TODO: YOUR CODE HERE

        if(n==null){
            return 0;
        }
        return n.heightHelper();
    }

    /**
     * 4-2 CTCI Minimum BST
     * Given a sorted array of unique integers, build the binary tree
     * with the minimum number of levels. This shouldn't bee
     * too hard!
     */

    public static BinaryTree minimumBST(int[] nums){
        BinaryTree bst = new BinaryTree(minBSTHelper(nums,0,nums.length-1));
        return bst;
    }

    public static TreeNode minBSTHelper(int[] nums, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(nums[mid]);
        n.left = minBSTHelper(nums, start,mid-1);
        n.right = minBSTHelper(nums,mid+1,end);
        return n;
    }

    /* Returns true if the tree's left and right children are the same height
       and are themselves completely balanced. */
    public boolean isCompletelyBalanced() {
        // TODO: YOUR CODE HERE
        return false;
    }

    /* Returns a BinaryTree representing the Fibonacci calculation for N. */
    public static ArrayList<Integer> fibList = new ArrayList<>();

    /* Returns a BinaryTree representing the Fibonacci calculation for N. */
    public static BinaryTree<Integer> fibTree(int N) {

        fibList.add(0);
        fibList.add(1);
        for(int i=0;i<N;i++){
            fibList.add(fibList.get(i) +fibList.get(i+1));
        }
        BinaryTree<Integer> result = new BinaryTree<Integer>(new TreeNode<>(fibList.get(N)));
        if(N==0||N==1){
            return result;
        }
        fibhelper(result.root);
        return result;
    }

    public static void fibhelper(TreeNode root){
        if(root.item.equals(0)){
            return;
        }
        if(root.item.equals(1)){
            root.left=new TreeNode(1);
            root.right= new TreeNode(0);
            return;
        }
        int i=0;
        while(fibList.get(i)!=root.item){
            i++;
        }
        root.left=new TreeNode(fibList.get(i-1));
        root.right=new TreeNode(fibList.get(i-2));
        if(root.left.item.equals(1)&&root.right.item.equals(1)){
            fibhelper(root.left);
            return;
        }
        fibhelper(root.left);
        fibhelper(root.right);

    }

    /* Print the values in the tree in preorder: root value first, then values
       in the left subtree (in preorder), then values in the right subtree
       (in preorder). */
    public void printPreorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printPreorder();
            System.out.println();
        }
    }

    /* Print the values in the tree in inorder: values in the left subtree
       first (in inorder), then the root value, then values in the first
       subtree (in inorder). */
    public void printInorder() {
        if (root == null) {
            System.out.println("(empty tree)");
        } else {
            root.printInorder();
            System.out.println();
        }
    }

    /* Prints out the contents of a BinaryTree with a description in both
       preorder and inorder. */
    private static void print(BinaryTree t, String description) {
        System.out.println(description + " in preorder");
        t.printPreorder();
        System.out.println(description + " in inorder");
        t.printInorder();
        System.out.println();
    }

    /* Fills this BinaryTree with values a, b, and c. DO NOT MODIFY. */
    public void sampleTree1() {
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c"));
    }

    /* Fills this BinaryTree with values a, b, and c, d, e, f. DO NOT MODIFY. */
    public void sampleTree2() {
        root = new TreeNode("a",
                new TreeNode("b", new TreeNode("d", new TreeNode("e"),
                        new TreeNode("f")), null), new TreeNode("c"));
    }

    /* Fills this BinaryTree with the values a, b, c, d, e, f. DO NOT MODIFY. */
    public void sampleTree3() {
        root = new TreeNode("a", new TreeNode("b"), new TreeNode("c",
                new TreeNode("d", new TreeNode("e"), new TreeNode("f")), null));
    }

    /* Fills this BinaryTree with the same leaf TreeNode. DO NOT MODIFY. */
    public void sampleTree4() {
        TreeNode leafNode = new TreeNode("c");
        root = new TreeNode("a", new TreeNode("b", leafNode, leafNode),
                new TreeNode("d", leafNode, leafNode));
    }

    /* Creates two BinaryTrees and prints them out in inorder. */
    public static void main(String[] args) {
        BinaryTree t;
        t = new BinaryTree();
        print(t, "the empty tree");
        t.sampleTree1();
        print(t, "sample tree 1");
        t.sampleTree2();
        print(t, "sample tree 2");

        //t=fibTree(5);
        //print(t,"fib tree of 5");
    }

    /* Note: this class is public in this lab for testing purposes. However,
       in professional settings as well as the rest of your labs and projects,
       we recommend that you keep your inner classes private. */
    static class TreeNode<T> {
        //TODO: should be private
        public T item;
        public TreeNode left;
        public TreeNode right;

        TreeNode(T obj) {
            item = obj;
            left = null;
            right = null;
        }

        TreeNode(T obj, TreeNode<T> left, TreeNode<T> right) {
            item = obj;
            this.left = left;
            this.right = right;
        }

        public T getItem() {
            return item;
        }

        public TreeNode<T> getLeft() {
            return left;
        }

        public TreeNode<T> getRight() {
            return right;
        }

        void setItem(T item) {
            this.item = item;
        }

        void setLeft(TreeNode<T> left) {
            this.left = left;
        }

        void setRight(TreeNode<T> right) {
            this.right = right;
        }

        private void printPreorder() {
            System.out.print(item + " ");
            if (left != null) {
                left.printPreorder();
            }
            if (right != null) {
                right.printPreorder();
            }
        }

        private void printInorder() {
            if (left != null) {
                left.printInorder();
            }
            System.out.print(item + " ");
            if (right != null) {
                right.printInorder();
            }
        }

        // TODO: ADD HELPER METHODS HERE
        public int heightHelper(){
            if(this==null){
                return 0;
            }
            if(this.left==null && this.right==null){
                return 1;
            }
            if(this.left==null){
                return 1 + this.right.heightHelper();
            }
            if(this.right==null){
                return 1 + this.left.heightHelper();
            }
            return 1+Math.max(this.left.heightHelper(),this.right.heightHelper());
        }
    }

}
