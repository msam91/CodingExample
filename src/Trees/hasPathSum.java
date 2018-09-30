package Trees;

import java.util.ArrayList;
import java.util.List;


class hasPathSum {
    
    public List<List<Integer>> list = new ArrayList<>();
    
    public static void main(String args[]){
        hasPathSum p = new hasPathSum();
        tNode root = new tNode(5);
        root.left = new tNode(4);
        root.right = new tNode(8);
        root.left.left = new tNode(11);
        root.left.left.left = new tNode(7);
        root.left.left.right = new tNode(2);
        root.right.left = new tNode(13);
        root.right.right = new tNode(4);
        root.right.right.left = new tNode(5);
        root.right.right.right = new tNode(1);
        p.pathSum(root, 22);
    }

   public List<List<Integer>> pathSum(tNode root, int sum) {
       List<Integer> nodeList = new ArrayList<>();
       if(root==null){
           return list;
       }
       pathSum(root,sum,nodeList);
       return list;
   }
   
   public void pathSum(tNode root, int sum, List<Integer> nodeList){   
       if(root==null){
           return;
       }
       nodeList.add(root.data);
       if(root.left ==null && root.right ==null && sum==root.data){         
               list.add(new ArrayList<Integer>(nodeList));
       }
      else{
       pathSum(root.left,sum-root.data,nodeList);
       pathSum(root.right,sum-root.data,nodeList);
      }
       nodeList.remove(nodeList.size()-1);
      
   }
}
