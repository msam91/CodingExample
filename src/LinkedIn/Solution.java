package LinkedIn;

import java.util.HashMap;
import java.util.Map;

class Solution {

    static final int no_of_chars = 256;
    
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.print(s.minWindow("aa", "aa"));
    }

    public String minWindow(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();

        // check if string's length is less than pattern's
        // length. If yes then no such window can exist
        if (len1 < len2)
        {
            return "";
        }

        Map<Character,Integer> charSet = new HashMap<Character,Integer>();

        for (int i = 0; i < len2; i++) {
            if(charSet.containsKey(pat.charAt(i))){
                charSet.put(pat.charAt(i), charSet.get(pat.charAt(i)+1));
            }
            else{
                charSet.put(pat.charAt(i),1);
            }
        }

        int window = len2;
        while (window <= len1) {
            int start = 0;
            while (start + window <= len1) {
                Map<Character,Integer> temp = new HashMap<Character,Integer>(charSet);
                String sub = str.substring(start, start+window);
                for (int i = 0; i < sub.length(); i++) {
                    if (temp.containsKey(sub.charAt(i))&& temp.get(sub.charAt(i))==1) {
                        temp.remove(sub.charAt(i));
                    }
                    else if(temp.containsKey(sub.charAt(i))){
                        temp.put(sub.charAt(i), temp.get(sub.charAt(i)-1));
                    }
                        if (temp.isEmpty()) {
                            return sub;
                        }
                }
                start += 1;
            }
            window += 1;
        }

        return "";
    }
}
