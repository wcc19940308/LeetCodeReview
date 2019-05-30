package LeetCode;

public class Trie {

    public static class TireNode {
        int R = 26;
        TireNode[] links;
        boolean isEnd;

        public TireNode() {
            links = new TireNode[26];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TireNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TireNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    TireNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TireNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TireNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public TireNode searchPrefix(String word) {
        TireNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TireNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TireNode node = searchPrefix(prefix);
        return node != null;
    }
}
