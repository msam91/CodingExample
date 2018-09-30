package ThumbTack;

import java.util.HashMap;
import java.util.Map;

public class Trie {

    class TrieNode {

        private Map<Character, TrieNode> children;
        private boolean endOfWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
        }

    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode trieNode = current.children.get(ch);
            if (trieNode == null) {
                trieNode = new TrieNode();
                current.children.put(ch, trieNode);
            }
            current = trieNode;
        }
        current.endOfWord = true;
    }

    public void findAllStrings(TrieNode current, StringBuilder sb) {
        if (current.endOfWord) {
            System.out.println(sb.toString());
        }
        if (current.endOfWord && current.children.isEmpty()) {
            return;
        }

        if (!current.children.isEmpty()) {
            for (Character ch : current.children.keySet()) {
                findAllStrings(current.children.get(ch), sb.append(ch));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public void searchByPref(String pref) {
        TrieNode current = root;
        for (int i = 0; i < pref.length(); i++) {
            char ch = pref.charAt(i);
            TrieNode trieNode = current.children.get(ch);
            if (trieNode == null) {
                return;
            }
            current = trieNode;
        }

        StringBuilder sb = new StringBuilder(pref);
        findAllStrings(current, sb);
    }

    public static void main(String args[]) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("cat");
        trie.insert("cow");
        trie.insert("dog");
        trie.searchByPref("ca");
    }

}
