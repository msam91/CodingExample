package comaparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String args[]) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("1","manas"));
  

        

          
        //Sort on basis of last digit seperate Comparator
       Comparator<Student> c = new Comp();
       Collections.sort(list,c);
       for(Student s : list){
           System.out.println(s.name);
       }
       System.out.println("---------------");
       
       Collections.sort(list,(s1,s2)->{
          return s1.name.compareTo(s2.name)>0 ? 1 : 0;
       });
       
       for(Student s : list){
           System.out.println(s.name);
       }
       System.out.println("---------------");
       


    }
}
