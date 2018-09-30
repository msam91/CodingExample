package uber;

import java.util.HashSet;
import java.util.Set;

class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String>set = new HashSet<String>();
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){               
                char ch = board[i][j];
                if(ch !='.'){                    
                    if(!set.add("row"+i+"-"+ch) || !set.add("row"+j+"-"+ch) || !set.add(i/3+"-"+j/3+"box"+"-"+ch)){
                        return false;
                    }
                }                  
            }
        }
        return true;
    }
}
