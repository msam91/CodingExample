package Trees;

import java.util.ArrayList;
import java.util.List;

public class isBinarySearchTree {
    public static void main(String args[])
    {
        
        tNode root = new tNode(4);
        root.left = new tNode(2);
        root.right = new tNode(5);
        root.left.left = new tNode(1);
        root.left.right = new tNode(3);
        List<tNode>nodeList = new ArrayList<tNode>();
        System.out.print(isBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE));
    

        
    }

    private static boolean isBST(tNode node,int max,int min) {
       
        if(node==null){
            return true;
        }
        if(node.data>max || node.data<=min){
            return false;
        }
        boolean isLeftBST = isBST(node.left,node.data,min);
        boolean isRightBST = isBST(node.right, max,node.data );
        
        if(isLeftBST && isRightBST){
            return true;
        }
       
        return false;
        
    }
    
}
