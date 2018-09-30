package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



class LargestValueFromRow {
    
    List<List<tNode>>list = new ArrayList<>();
    Map<Integer,Integer>lv = new HashMap<Integer,Integer>();
   
    public static void main(String args[])
    {
        
        tNode root = new tNode(10);
        root.left = new tNode(5);
        root.right = new tNode(15);
        root.right.left = new tNode(6);
        root.right.right = new tNode(20);
        List<tNode>nodeList = new ArrayList<tNode>();
        LargestValueFromRow l = new LargestValueFromRow();
        l.largestValues(root);
       
    }
        
    public List<Integer> largestValues(tNode root) {
        if(root == null){
            return null;
        }
        getLargestValue(root,0);
        return new ArrayList<Integer>(lv.values());      
    }
    
    public void getLargestValue(tNode root, int level){       
        List<tNode> nodeList =null;       
        if(root==null){
            return;
        }       
        if(list.size()==level){
            nodeList = new ArrayList<tNode>();
            list.add(nodeList);
            lv.put(level,root.data);
        }
        else{
            nodeList = list.get(level);
            if(lv.containsKey(level) && lv.get(level)<root.data){
                lv.put(level,root.data);
            }
        }
        nodeList.add(root);       
        getLargestValue(root.left,level+1);
        getLargestValue(root.right,level+1);
    }
}
