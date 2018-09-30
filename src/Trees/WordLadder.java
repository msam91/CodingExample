package Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public static Set<String> dict = new HashSet<String>();

    public static void main(String args[]) {
        String start = "hit";
        String end = "cog";
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        WordLadder wl = new WordLadder();
        //System.out.println(wl.getLadderLength(start, end));
        wl.findLadders(start, end, dict);

    }

    public int getLadderLength(String beginWord, String endWord) {

        LinkedList<WordNode> q = new LinkedList<WordNode>();
        q.add(new WordNode(beginWord, 1, null));
        dict.add(endWord);

        while (!q.isEmpty()) {
            print(q);
            WordNode top = q.remove();
            String currentWord = top.word;

            if (currentWord.equals(endWord)) {
                return top.count;
            }
            else {

                char a[] = currentWord.toCharArray();

                for (int i = 0; i < a.length; i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char temp = a[i];
                        if (a[i] != ch) {
                            a[i] = ch;
                        }
                        String newWord = new String(a);
                        if (dict.contains(newWord)) {
                            q.add(new WordNode(newWord, top.count + 1, null));
                            dict.remove(newWord);
                        }
                        a[i] = temp;
                    }
                }
            }

        }

        return q.remove().count;

    }

    private void print(LinkedList<WordNode> q) {
        for (WordNode n : q) {
            System.out.print(n.word + n.count + "-->");
        }
        System.out.println();

    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();

        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(start, 1, null));

        dict.add(end);

        int minStep = 0;

        HashSet<String> visited = new HashSet<String>();
        HashSet<String> unvisited = new HashSet<String>();
        unvisited.addAll(dict);

        int preNumSteps = 0;

        while (!queue.isEmpty()) {
            WordNode top = queue.remove();
            String word = top.word;
            int currNumSteps = top.count;

            if (word.equals(end)) {
                if (minStep == 0) {
                    minStep = top.count;
                }

                if (top.count == minStep && minStep != 0) {
                    // nothing
                    ArrayList<String> t = new ArrayList<String>();
                    t.add(top.word);
                    while (top.prev != null) {
                        t.add(0, top.prev.word);
                        top = top.prev;
                    }
                    result.add(t);
                    continue;
                }

            }

            if (preNumSteps < currNumSteps) {
                unvisited.removeAll(visited);
            }

            preNumSteps = currNumSteps;

            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c) {
                        arr[i] = c;
                    }

                    String newWord = new String(arr);
                    if (unvisited.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.count + 1, top));
                        visited.add(newWord);
                    }

                    arr[i] = temp;
                }
            }

        }

        return result;
    }
}

class WordNode {
    public String word;
    public int count;
    public WordNode prev;

    public WordNode(String word, int count, WordNode prev) {
        this.word = word;
        this.count = count;
        this.prev = prev;

    }

}
