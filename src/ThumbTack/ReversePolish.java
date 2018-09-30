package ThumbTack;

import java.util.Stack;

class ReversePolish {
    public int evalRPN(String[] tokens) {
        
        Stack<String>stack = new Stack<String>();
        String operator = "+-*/";
        int result =0; 
            
        for(int i=0;i<tokens.length;i++){
            
            if(!operator.contains(tokens[i])){
                stack.push(tokens[i]);
            }  
            else{
                int number2 = Integer.parseInt(stack.pop());
                int number1 = Integer.parseInt(stack.pop());              
                switch(tokens[i]){
                        
                    case "+": result=number1+number2;
                              break;                       
                    case "-": result=number1-number2;
                              break;
                    case "*": result=number1*number2;
                              break;
                    case "/": result=number1/number2;
                              break;                       
                }
                stack.push(String.valueOf(result));                
            }
            
        }        
        return Integer.parseInt(stack.pop());
    }
    
}
