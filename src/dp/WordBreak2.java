package dp;

import java.util.*;


public class WordBreak2 {

    private static List<List<String>> finalResult = new ArrayList<List<String>>();

    public static void main(String args[]) throws Exception {
        String text = "helloworld!";
        String sList[] = { "hell", "hello","o" ,"world", "!"};

        Set<String> dict = new HashSet<String>(Arrays.asList(sList));
        WordBreak2 s = new WordBreak2();
        List<String> result = new ArrayList<String>();
        s.getResult(text, dict);

        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < finalResult.size(); i++) {
            if (min >finalResult.get(i).size()) {
                min = finalResult.get(i).size();
                index = i;
            }

        }
        if(index !=-1){
        List<String> res = finalResult.get(index);
        
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }
        }
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }

    private void getResult(String word, Set<String> dict) {

        if (word == null || word.isEmpty()) {
            return;
        }

        Map<Integer, List<String>> tempMap = new HashMap<Integer, List<String>>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String s = word.substring(i, j);
                if (dict.contains(s)) {
                    List<String> tempList = tempMap.get(j - 1);
                    if (tempList == null) {
                        tempList = new ArrayList<String>();
                    }
                    tempList.add(s);
                    tempMap.put(j - 1, tempList);
                }
            }

        }

        if (!tempMap.containsKey(word.length() - 1)) {
            return;
        }
        else {
            ArrayList<String> result = new ArrayList<String>();
            getPresentWords(tempMap, result, word.length() - 1);
        }

    }

    public void getPresentWords(Map<Integer, List<String>> tempMap, ArrayList<String> tempList, int i) {
        if (i == -1) {
            finalResult.add(new ArrayList<String>(tempList));
            return;
        }

        if (tempMap.containsKey(i)) {
            for (String s : tempMap.get(i)) {
                tempList.add(s);
                getPresentWords(tempMap, tempList, i - s.length());
                tempList.remove(s);
            }
        }
    }

}
