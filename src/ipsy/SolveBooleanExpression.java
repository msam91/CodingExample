package ipsy;

import java.util.Stack;

public class SolveBooleanExpression {

    public static void main(String args[]) {
        SolveBooleanExpression s = new SolveBooleanExpression();
        System.out.print(s.solveExpression("!!!false|true&false|false&true|false"));
    }

    public boolean solveExpression(String expression) {

        String exp = generateString(expression);
        String oldStr[] = exp.split(" ");
        String str[] = getModifiedExpression(oldStr);
        Stack<String> st = new Stack<String>();

        if (str.length == 1) {
            return Boolean.parseBoolean(str[0]);
        }
        else {

            int i = 0;
            while (i < str.length) {
                if (!str[i].equals("&")) {
                    st.push(str[i]);
                    i++;
                }
                else {
                    String op1 = st.pop();
                    String op2 = str[i + 1];
                    String result = String.valueOf(Boolean.parseBoolean(op1) && Boolean.parseBoolean(op2));
                    st.push(result);
                    i += 2;
                }
            }
            while (!st.isEmpty()) {
                String s = st.pop();
                if (s.equals("true")) {
                    return true;
                }

            }

            return false;

        }

    }
    
    public String generateString(String exp){
        
        char  expArr [] = exp.toCharArray();
        StringBuffer sb = new StringBuffer();
        int i=0;
        while(i<expArr.length){
           char ch = expArr[i];
            if(isOperator(ch)){
                sb.append(ch);
                i++;
            }
            else if(ch=='f'){
                sb.append("false");
                i+=5;
            }
            else if(ch=='t'){
                sb.append("true");
                i+=4;
            }
            sb.append(" ");
        }
        return sb.toString();
        
    }
    
    public boolean isOperator(char ch){
        if(ch=='f' || ch=='t'){
            return false;
        }
        
        return true;
    }

    public String[] getModifiedExpression(String[] str) {
        int i = 0;
        int countOfNot = 0;
        while (i < str.length) {
            if (str[i].equals("!")) {
                countOfNot++;
                i++;
            }
            else {
                if (countOfNot % 2 != 0) {
                    str[i] = String.valueOf(!Boolean.parseBoolean(str[i]));
                }
                countOfNot = 0;
                i++;
            }
        }
        return str;
    }

}
