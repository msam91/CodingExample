package goldManSachs;

public class ReverseString {
    
    public static void main(String args[]){
        String s = "the sky is blue";
        ReverseString rs = new ReverseString();
        rs.reverseWords(s.toCharArray());
        
    }
    public void reverseWords(char[] s) {
        int i=0;
        for(int j=0; j<s.length; j++){
            if(s[j]==' '){
                reverse(s, i, j-1);        
                i=j+1;
            }
        }
     
        reverse(s, i, s.length-1);
     
        reverse(s, 0, s.length-1);
        
        for(int j=0;j<s.length;j++){
            System.out.print(s[j]);
        }
    }
     
    public void reverse(char[] s, int i, int j){
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
