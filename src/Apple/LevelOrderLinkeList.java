package Apple;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;



public class LevelOrderLinkeList {
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

}

class tNode
{
    int data;
    tNode left, right;

    tNode(int item)
    {
        data = item;
        left = right = null;
    }

    @Override
    public String toString() {
        return "tNode [data=" + data + "]";
    }

}
