package goldManSachs;

public class MaxSumLeaves {

    static Node root;
    public int max = Integer.MIN_VALUE;

    int maxPath(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return node.data;

        int ls = maxPath(node.left);
        int rs = maxPath(node.right);

        if (node.left != null && node.right != null) {
            max = Math.max(max, ls + rs + node.data);
            return Math.max(ls, rs) + node.data; // if not leaf to leaf then
                                                 // Math.max(Math.max(ls, rs) +
                                                 // node.data,node.data);
        }

        return (node.left == null) ? rs + node.data
                : ls + node.data;
    }

    


    /* int max_single = Math.max(Math.max(l, r) + node.data,node.data);
     * int max_top = Math.max(max_single, l + r + node.data);
     * 
     * // Store the Maximum Result. res.val = Math.max(res.val, max_top);
     * 
     * return max_single;
     */

    // Driver program to test above functions
    public static void main(String args[]) {
        MaxSumLeaves tree = new MaxSumLeaves();
        tree.root = new Node(-15);
        tree.root.left = new Node(5);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(-8);
        tree.root.left.right = new Node(1);
        tree.root.left.left.left = new Node(2);
        tree.root.left.left.right = new Node(6);
        tree.root.right.left = new Node(3);
        tree.root.right.right = new Node(9);
        tree.root.right.right.right = new Node(0);
        tree.root.right.right.right.left = new Node(4);
        tree.root.right.right.right.right = new Node(-1);
        tree.root.right.right.right.right.left = new Node(10);
        tree.maxPath(root);
        System.out.println("Max pathSum of the given binary tree is "
                + tree.max);
    }
}

// Java program to find maximum path sum between two leaves
// of a binary tree
class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

// An object of Res is passed around so that the
// same value can be used by multiple recursive calls.
class Res {
    int val;
}
