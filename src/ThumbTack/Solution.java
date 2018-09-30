package ThumbTack;

import java.util.Stack;

class Solution {
	  public static void main(String[] args) {
	    
	   //int result = solveExpression("12+6-3");
	   //int result = solveExpression("6+9-12");
	   int result = solveExpression("5+16-((9-6)-(4-2))");
	   System.out.print(result); 
	    
	  }
	  
	  
	  public static int solveExpression(String s){
	    
	    int result =0;
	    int number = 0;
	    int sign =1;
	    
	    Stack<Integer> st = new Stack<Integer>();
	    
	    for(char ch : s.toCharArray()){

	     if(Character.isDigit(ch)){     
	        number = number*10 + (ch-'0');      
	     }
	      
	     if( ch == '+'){      
	       result+=number*sign;
	       sign =1;
	       number =0;
	     }
	      
	     if(ch == '-'){
	       result+=number*sign;
	       sign = -1;
	       number =0;       
	     }
	     
	     if(ch == '('){
	       st.push(result);
	       st.push(sign);       
	       result=0;
	       sign=1;
	       
	     }
	    
	     if(ch == ')'){
	       result+= number*sign;
	       result*=st.pop();
	       result+=st.pop();
	       number =0;
	   
	     }
	                 
	    }
	    result+=number*sign;
	    return result;
	    
	    
	  }
	}