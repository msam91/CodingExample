package Apple;

import java.util.LinkedList;
import java.util.Queue;

public class Escape {

    public static void main(String args[]){
        
        String s = "audi premium";
      
        Queue<Integer>q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        System.out.print(q.remove());
        System.out.print(q.peek());
        System.out.print(q.poll());
        
        
    }
}
