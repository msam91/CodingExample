package goldManSachs;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {

    public static void main(String args[]) {
        System.out.print(isAnagram("ggod", "dogg"));
    }

    private static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> charCount = new HashMap<Character, Integer>();

        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (charCount.containsKey(ch)) {
                charCount.put(ch, charCount.get(ch) + 1);
            }
            else {
                charCount.put(ch, 1);
            }
        }

        for (int j = 0; j < s2.length(); j++) {
            char ch = s2.charAt(j);
            if (charCount.containsKey(ch)) {
                int count = charCount.get(ch) - 1;
                if (count == 0) {
                    charCount.remove(ch);
                }
                else {
                    charCount.put(ch, count);
                }
            }
            else {
                return false;
            }

        }
        if (charCount.size() > 0) {
            return false;
        }
        return true;
    }
}
