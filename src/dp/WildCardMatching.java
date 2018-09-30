package dp;
class WildCardMatching {
    
    public static void main(String args[]){
        WildCardMatching w = new WildCardMatching();
        System.out.print(w.isMatch("aa", "*"));
    }
    
    
    public boolean isMatch(String s, String p) {
        boolean table[][]= new boolean [s.length()+1][p.length()+1];
        table[0][0]=true;
        
        for(int i=1;i<table[0].length;i++){
            if(p.charAt(i-1)=='*'){
                table[0][i]=table[0][i-1];
            }
        }

        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){

                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    table[i][j]=table[i-1][j-1];                      
                }
                else if(p.charAt(j-1)=='*'){
                    table[i][j]=table[i][j-1]||table[i-1][j];
                }
                else{
                    table[i][j]=false;
                }
            
            }
    }
        return table[s.length()][p.length()];
}
}
