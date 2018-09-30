package List;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class InterviewAug {

    public class Index {

        int currentIndex;
        int minDiff;

        @Override
        public String toString() {
            return "Index [currentIndex=" + currentIndex + ", minDiff=" + minDiff + "]";
        }

    }

    public static void main(String args[]) {
        InterviewAug i = new InterviewAug();
        System.out.println(i.getFirstRepeatedWord("he is action he he action is is"));
        System.out.print(i.longestSubstring("abcd"));
    }

    public String getFirstRepeatedWord(String s) {

        String strArr[] = s.split(" ");
        Map<String, Index> map = new HashMap<String, Index>();
        Index index = null;
        for (int i = 0; i < strArr.length; i++) {
            if (!map.containsKey(strArr[i])) {
                index = new Index();
                index.currentIndex = i;
                index.minDiff = Integer.MAX_VALUE;
                map.put(strArr[i], index);
            }
            else {
                index = map.get(strArr[i]);
                if (index.minDiff > i - index.currentIndex) {
                    index.minDiff = i - index.currentIndex;
                }
                index.currentIndex = i;
            }
        }
        int min = Integer.MAX_VALUE;
        int startIndex = Integer.MAX_VALUE;
        String result = null;
        for (String key : map.keySet()) {
            Index i = map.get(key);
            if (i.minDiff <= min) {
                if (i.minDiff == min && i.currentIndex > startIndex)
                    continue;

                min = i.minDiff;
                result = key;
                startIndex = i.currentIndex;
            }

        }
        return result;

    }

    public String longestSubstring(String s) {
        char ch[] = s.toCharArray();
        Set<Character> charSet = new HashSet<Character>();
        char prevChar = ch[0];
        int startIndex = 0;
        String longestString = "";
        int length = 0;
        for (int i = 0; i < ch.length; i++) {
            if (!charSet.contains(ch[i])) {
                charSet.add(ch[i]);
                if (charSet.size() > 2) {
                    if (i - startIndex > length) {
                        length = i - startIndex;
                        longestString = s.substring(startIndex, i);
                    }
                    int j = i - 1;
                    while (ch[j] == prevChar) {
                        j--;
                    }
                    startIndex = j + 1;
                    charSet.remove(ch[j]);

                }
            }
            prevChar = ch[i];
        }

        if (charSet.size() == 2) {
            if (s.length() - 1 - startIndex > length) {
                length = s.length() - 1 - startIndex;
                longestString = s.substring(startIndex, s.length());
            }
        }
        return longestString;
    }
}
