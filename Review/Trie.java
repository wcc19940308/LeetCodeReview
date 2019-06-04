package LeetCode.Review;

public class Trie {

    public static class Node {
        int R = 26;
        Node[] links;
        boolean isEnd;

        public Node() {
            links = new Node[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public Node getKey(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for (Character ch : word.toCharArray()) {
            if (node.getKey(ch) == null) {
                node.put(ch, new Node());
            }
            node = node.getKey(ch);
        }
        node.setEnd();
    }

    public Node searchPrefix(String word) {
        Node node = root;
        for (Character ch : word.toCharArray()) {
            if (node.getKey(ch) == null) {
                return null;
            }
            node = node.getKey(ch);
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
