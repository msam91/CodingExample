package dp;

public class MinimumEditDistance {
    public static void main(String args[]) {

        MinimumEditDistance m = new MinimumEditDistance();
        String s1="abc";
        String s2="apc";

        System.out.println(m.minEditDistance(s1,s2));
        System.out.println(m.minEditDistanceRec(s1,s2,s1.length(),s2.length()));

    }

    private int minEditDistanceRec(String s1, String s2, int m, int n){
        
        if(n==0){
            return m;
        }
        if(m==0){
            return n;
        }
        
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return minEditDistanceRec(s1,s2,m-1,n-1);
        }
        else{
            return 1+ Math.min(Math.min(minEditDistanceRec(s1,s2,m,n-1), minEditDistanceRec(s1,s2,m-1,n)),minEditDistanceRec(s1,s2,m-1,n-1));
        }
        
    }
    private int minEditDistance(String s1, String s2) {
        // TODO Auto-generated method stub
        int table[][] = new int [s1.length()+1][s2.length()+1];
        
        for(int i=0;i<=s1.length();i++){
            
            for(int j=0;j<=s2.length();j++){
                
                if(i==0 && j==0){
                    table[i][j]=0;
                }
                else if(i==0 && j!=0){
                    table[i][j]=j;
                }
                else if(i!=0 && j==0){
                    table[i][j]=i;
                }
                else{
                    if(s1.charAt(i-1)==s2.charAt(j-1)){
                        table[i][j]= table[i-1][j-1];
                    }
                    else{
                        table[i][j]= 1+Math.min(Math.min(table[i-1][j],table[i][j-1]),table[i-1][j-1]);
                    }
                }
            }
        }
        
        printActualEdits(table, s1.toCharArray(), s2.toCharArray());
        return table[s1.length()][s2.length()];
    }
    
    public void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i-1]);
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in string2 " + str2[j-1]);
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }
}
