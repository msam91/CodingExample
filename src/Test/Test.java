package Test;

import java.io.UnsupportedEncodingException;

public class Test {
    
    
    public static void main(String args[]) throws UnsupportedEncodingException{
        
        byte[]b = {48,52,55};       
        String s = new String(b); 
        
        System.out.println(s);
        
        System.out.println(s.getBytes());

        
    }

}
