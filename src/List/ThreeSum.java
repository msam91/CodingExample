package List;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ThreeSum {
    List<List<Integer>>finalResult = new java.util.ArrayList<List<Integer>>();
    
    public static void main(String args[]){
        
        ThreeSum s = new ThreeSum();
        int nums[] ={-1,0,1,2,-1,-4};
        s.threeSum(nums);
    }
    
   
    
    public List<List<Integer>> threeSum(int[] nums) {
        
        Map<Integer,List<Integer>>indexMap = new HashMap<Integer,List<Integer>>();        
        for(int i=0;i<nums.length;i++){           
            List<Integer>temp =null;
            if(!indexMap.containsKey(nums[i])){
               temp = new  java.util.ArrayList<Integer>();              
            }else{
                temp = indexMap.get(nums[i]);
            }
            temp.add(i);
            indexMap.put(nums[i],temp);
            
        }
        for(int i=0;i<nums.length-1;i++){           
            for(int j=i+1;j<nums.length;j++){
                int key = (nums[i]+nums[j])*-1;
                if(indexMap.containsKey(key)){
                   List<Integer>temp = indexMap.get(key);
                    formTriplet(nums,nums[i],nums[j],temp);
                }
            }
            
        }
        return finalResult;
    }
    
    private void formTriplet(int[]nums,int i,int j, List<Integer>temp){
        List<Integer> result =null;
        for(int k : temp){
           result = new java.util.ArrayList<Integer>();
            result.add(i);
            result.add(j);
            result.add(nums[k]);         
        } 
        if(result!=null){
        finalResult.add(result); 
        }
    }
}
