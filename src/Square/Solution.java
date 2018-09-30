package Square;

import java.io.*;
import java.util.*;

/*
 * Problem definition
 * 
 * A node has a name, and ordered child nodes. Given a root node, we want to
 * pretty print the node hierarchy so that it looks nice in a terminal, by
 * printing the child nodes in order and adding a space for each level of
 * hierarchy.
 * 
 * Let’s look at an example (we’re not printing this one!):
 * 
 * Root / \ / \ / \ / \ A B / | \ / \ / | \ / \ A1 A2 A3 B1 B2 / \ / \ A2a A2b
 * 
 * Here would be the expected output:
 * 
 * Root A A1 A2 A2a A2b A3 B B1 B2
 * 
 * `-Root +-A +-A1 +-A2 +-A2a `-A2b `-A3 `-B +-B1 `-B2
 */

class Solution {
    public static void main(String[] args) {

        TreeNode root = new TreeNode("root");
        TreeNode lChild = new TreeNode("A");
        TreeNode rChild = new TreeNode("B");
        root.children.add(lChild);
        root.children.add(rChild);

        TreeNode AChild1 = new TreeNode("A1");
        TreeNode AChild2 = new TreeNode("A2");
        TreeNode AChild3 = new TreeNode("A3");

        TreeNode A2Child1 = new TreeNode("A2a");
        TreeNode A2Child2 = new TreeNode("A2b");

        AChild2.children.add(A2Child1);
        AChild2.children.add(A2Child2);

        TreeNode BChild1 = new TreeNode("B1");
        TreeNode BChild2 = new TreeNode("B2");

        lChild.children.add(AChild1);
        lChild.children.add(AChild2);
        lChild.children.add(AChild3);

        rChild.children.add(BChild1);
        rChild.children.add(BChild2);

        printTreeFirst(root, 0);
        printTree(root, 0,true);

    }
    
    public static void printTreeFirst(TreeNode root, int numberOfSpace) {

        if (root == null) {
            return;
        }        
        for (int i = 0; i < numberOfSpace; i++) {
            System.out.print(" ");
        }

        System.out.println("-" + root.name);

        if (root.children.isEmpty()) {
            return;
        }
        else {
            for (int i = 0; i < root.children.size(); i++) {
                printTreeFirst(root.children.get(i), numberOfSpace + 1);
            }

        }

    }

    public static void printTree(TreeNode root, int numberOfSpace, boolean isLastChild) {

        if (root == null) {
            return;
        }        
        for (int i = 0; i < numberOfSpace; i++) {
            System.out.print(" ");
        }
        if (isLastChild) {
            System.out.println("-" + root.name);
        }
        else {
            System.out.println("+" + "-" + root.name);
        }
        if (root.children.isEmpty()) {
            return;
        }
        else {
            for (int i = 0; i < root.children.size(); i++) {
                if (i != root.children.size() - 1) {
                    isLastChild = false;
                }
                else {
                    isLastChild = true;
                }
                printTree(root.children.get(i), numberOfSpace + 1, isLastChild);
            }

        }

    }

    static class TreeNode {
        private String name;
        private List<TreeNode> children;

        public TreeNode(String name) {
            this.name = name;
            children = new ArrayList<TreeNode>();

        }

    }
}
