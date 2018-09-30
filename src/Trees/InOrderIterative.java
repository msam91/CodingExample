package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {
    public static void main(String args[])
    {

        tNode root = new tNode(1);
        root.left = new tNode(2);
        root.right = new tNode(3);
        root.left.left = new tNode(4);
        root.left.right = new tNode(5);

        inOrderIter(root);

    }

    private static void inOrderIter(tNode root) {

        Stack<tNode> stack = new Stack<tNode>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                if (stack.isEmpty()) {
                    break;
                }
                root = stack.pop();
                System.out.print(root.data);
                root = root.right;
            }
        }
    }

}
