package Trees;

import java.util.ArrayList;
import java.util.List;

public class SecondMinBinTree {
    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    
    
    public static void main(String args[])
    {
        
        tNode root = new tNode(2);
        root.left = new tNode(2);
        root.right = new tNode(5);
        root.right.left = new tNode(5);
        root.right.right = new tNode(7);
      
        
    }
    
    public int findSecondMinimumValue(tNode root) {
        if(root==null){
            return -1;
        }
        findSecondMinimum(root);
        if(min==secondMin){
            return -1;
        }        
        return secondMin;       
    }
    
    public void findSecondMinimum(tNode root){
        
        if(root==null){
            return;
        }
        
        if(root.data<min){
            secondMin = min;
            min = root.data;
        }
        if(root.data<secondMin && root.data>min){
            secondMin=root.data;
        }
        findSecondMinimum(root.left);
        findSecondMinimum(root.right);
        
        
    }
}
