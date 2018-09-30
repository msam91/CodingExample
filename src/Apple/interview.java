package Apple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class interview {
    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


      
        // Maximum value of the integer array
    // Array is:
    // 1. Unsorted
    // 2. Contain any value of integer
    // 3. May contain duplicates.  
    // For brevity you can assume lists are not null,   not empty and do not exceed allowable memory.
      
     //  5,10,6,12,4,8
      public int max(int[] array) {
        
        int max = array[0];       
        for(int i=1;i<array.length;i++){         
          if(array[i]>max){
            max = array[i];             
          }         
        }
        return max;
      }
      
      
      
    //Example
    //list 1                                //list 2
    // (99, -10, 33, 33, 5, 25, -15, 4, 4) (4, -10, 100, -45, -3, 4)
    //  Result
    // (4, -10) 
       
    // Lists are:
    // 1. Unsorted
    // 2. Contain any value of integer
    // 3. May contain duplicates.  
    // For brevity you can assume lists are not null,   not empty and do not exceed allowable memory.
      
      public List<Integer> duplicates(List<Integer> list1, List<Integer> list2) {
      
        Set<Integer>dup = new HashSet<Integer>(list1);          
        dup.retainAll(list2);
        return new ArrayList<Integer>(dup);
              
      }
    

}





