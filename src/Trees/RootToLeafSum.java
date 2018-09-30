package Trees;

import java.util.ArrayList;
import java.util.List;


public class RootToLeafSum {

    public static void main(String args[])
    {
        
        tNode root = new tNode(1);
        root.left = new tNode(2);
        root.right = new tNode(3);
        root.left.left = new tNode(4);
        root.left.right = new tNode(5);
        List<tNode>nodeList = new ArrayList<tNode>();
        rootToLeafSum(root,8,nodeList);
        
        for(tNode node : nodeList){
            System.out.print(node.data+"-");
        }

        
    }

    private static boolean rootToLeafSum(tNode node, int sum, List<tNode> nodeList) {
        
      if(node==null){
          return false;
      }
      if(node.left==null && node.right==null){
          if(sum==node.data){
              nodeList.add(node);
              return true;
          }
      }
      boolean sumInLeft = rootToLeafSum(node.left,sum-node.data,nodeList);
      if(sumInLeft){
          nodeList.add(node);
          return true;
      }
      boolean sumInRight = rootToLeafSum(node.right,sum-node.data, nodeList);
      if(sumInRight){
          nodeList.add(node);
          return true;
      }
           
      return false;
      
    }
    
}
