package javaExample;

import java.util.ArrayList;
import java.util.List;

public class CallByValue {

    public static void main(String args[] ){
        int x =50;
        List<Integer>intList = new ArrayList<Integer>();
        intList.add(5);
        
        CallByValue call = new CallByValue();
        call.change(x,intList);
        
        for(int i=0;i<intList.size();i++){
           System.out.print(intList.get(i));
        }
        System.out.println();
        System.out.print(x);
        
    }

    private void change(int x, List<Integer> intList) {       
        x=100;
        intList.add(10);
    }
}
