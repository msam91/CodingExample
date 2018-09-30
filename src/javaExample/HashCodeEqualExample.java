package javaExample;


import java.util.HashMap;
import java.util.Map;



public class HashCodeEqualExample {
          
      public static void main(String args[]){
          
          Apple a = new Apple("green");
          Apple b = new Apple("red");
          
          Map<Apple,Integer>appleMap = new HashMap<Apple,Integer>();
          appleMap.put(a, 1);
          appleMap.put(b, 2);
          
          System.out.print(appleMap.get(new Apple("green")));
          
          
      }
}
      
      class Apple {
          
          private String colour;
         
         public Apple(String colour){
             this.colour=colour;
         }
         
         @Override
       public boolean equals(Object obj) {
             if(obj==null){
                 return false;
             }
             if(!(obj instanceof Apple)){
                 return false;
             }
             if(this== obj){
                 return true;
             }
             return this.colour.equals(((Apple)obj).colour);

       }
         
         @Override
         public int hashCode() {
            return this.colour.hashCode();
         }
      
      
  }

