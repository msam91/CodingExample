package ThumbTack;


import java.util.*;

public class IntersectionOfArrays {
    
    public static void main (String args[]){
  
        
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(3,2,5,5);
             
        IntersectionOfArrays i = new IntersectionOfArrays();
        i.duplicates(list1,list2);
        
    }
    public List<Integer> duplicates(List<Integer> list1, List<Integer> list2) {        
        Set<Integer>dup = new HashSet<Integer>(list1);          
        dup.retainAll(list2);
        return new ArrayList<Integer>(dup);              
      }
}
