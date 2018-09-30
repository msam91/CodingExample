package Roblox;

import java.util.Stack;

public class ImplementCd {
    
    public static void main(String args[]){       
        getDirectiry("/logs", "/test/nodes/../modules/logs");
        getDirectiry("/logs", "test/nodes/../modules/logs");
    }
    
    public static void getDirectiry(String src, String destination){
        
        Stack<String> directoryStack = new Stack<String>();
        
        String[] listDestination = destination.split("/");
        String[] listHost = src.split("/");
        
        if(!destination.startsWith("/")){
            for(String str : listHost){
                if(!(str.matches(".."))){
                    directoryStack.push(str);
                }
                else if((str.matches(".."))){
                    directoryStack.pop();
                }
            }
        }
        
        for(String str : listDestination){
            if(!(str.matches(".."))){
                directoryStack.push(str);
            }
            else if((str.matches(".."))){
                directoryStack.pop();
            }
        }
        
        while(!directoryStack.isEmpty())
        System.out.print(directoryStack.pop()+"->");
        
        System.out.println();
    }

}
