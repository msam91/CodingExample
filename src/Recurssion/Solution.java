package Recurssion;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String args[]){
        Solution s = new Solution();
        s.addOperators("123", 15);
    }
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num == null || num.length() == 0) return result;
        helper(result, "", num, target, 0, 0, 0);
        return result;
    }
    public void helper(List<String> result, String resultString, String num, int target, int pos, long prev, long multed){
        if(pos == num.length()){
            if(target == prev)
                result.add(resultString);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            //important step.
            long cur = Long.parseLong(num.substring(pos, i + 1));
            System.out.println(cur);
            
            if(pos == 0){
                helper(result, resultString + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(result, resultString + "+" + cur, num, target, i + 1, prev + cur , cur);
                
                helper(result, resultString + "-" + cur, num, target, i + 1, prev -cur, -cur);
                
                helper(result, resultString + "*" + cur, num, target, i + 1, prev - multed + multed * cur, multed * cur );
            }
        }
    }
}
