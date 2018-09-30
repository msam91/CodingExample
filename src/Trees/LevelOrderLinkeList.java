package Trees;

import java.util.LinkedList;
import java.util.List;

import java.util.ArrayList;

public class LevelOrderLinkeList {
    
    public static List<LinkedList<tNode>> reverseLevelOrder = new ArrayList<LinkedList<tNode>>();
    public static void main(String args[])
    {

        tNode root = new tNode(1);
        root.left = new tNode(2);
        root.right = new tNode(3);
        root.left.left = new tNode(4);
        root.left.right = new tNode(5);

        List<LinkedList<tNode>> levelOrder = new ArrayList<LinkedList<tNode>>();
        levelOrdertraversal(root, levelOrder, 0);
        for (int i = 0; i < levelOrder.size(); i++) {
            for (tNode node : levelOrder.get(i)) {
                System.out.print(node.data + "-->");
            }
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Level Order in reverse");
        
/*        
        Given binary tree 
                1
               / \
              2   3
             / \     
            4   5    
         Returns [4, 5, 3], [2], [1].
*/
        reverseLevelOrdertraversal(root);
        for (int i = 0; i < reverseLevelOrder.size(); i++) {
            for (tNode node : reverseLevelOrder.get(i)) {
                System.out.print(node.data + "-->");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("reverse level order");

        for (int i = levelOrder.size() - 1; i >= 0; i--) {
            for (tNode node : levelOrder.get(i)) {
                System.out.print(node.data + "-->");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("spiral level order");

        boolean leftToRight = true;

        for (int i = 0; i < levelOrder.size(); i++) {
            LinkedList<tNode> level = levelOrder.get(i);
            if (leftToRight) {
                leftToRight=false;
                for (int j = 0; j < level.size(); j++)
                    System.out.print(level.get(j).data+"-->");
            }
            else {
                leftToRight=true;
                for (int j = level.size() - 1; j >= 0; j--)
                    System.out.print(level.get(j).data+"-->");
            }

            System.out.println();
        }

    }

    private static void levelOrdertraversal(tNode node, List<LinkedList<tNode>> levelOrder, int level) {

        LinkedList<tNode> nodeList;
        if (node == null) {
            return;
        }
        if (levelOrder.size() == level) {
            nodeList = new LinkedList<tNode>();
            levelOrder.add(nodeList);
        }
        else {
            nodeList = levelOrder.get(level);
        }
        nodeList.add(node);
        levelOrdertraversal(node.left, levelOrder, level + 1);
        levelOrdertraversal(node.right, levelOrder, level + 1);

    }
    

    private static int reverseLevelOrdertraversal(tNode node) {

        if(node == null){
            return -1;
        }
        int leftDepth = reverseLevelOrdertraversal(node.left);
        int rightDepth = reverseLevelOrdertraversal(node.right);
        int level = Math.max(leftDepth,rightDepth)+1;
        
        LinkedList<tNode> nodeList;

        if (reverseLevelOrder.size() == level) {
            nodeList = new LinkedList<tNode>();
            reverseLevelOrder.add(nodeList);
        }
        else {
            nodeList = reverseLevelOrder.get(level);
        }
        nodeList.add(node);
        node.left=null;
        node.right=null;
        return level;

    }
    
    
    
}
