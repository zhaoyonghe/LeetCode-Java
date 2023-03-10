package ImplementTrie;

/**
 * Assume the word or prefix's length is n, the number of words is m.
 * Constructor Time Complexity: O(1)
 * insert Time Complexity: O(n)
 * search Time Complexity: O(n)
 * startsWith Time Complexity: O(n)
 * Space Complexity: O(m * n)
 * Runtime: 114ms
 * Rank: 99.30%
 */
public class Trie {
    private class Node {
        public char c;
        public boolean isExist = false;
        public Node[] nodes = new Node[26];

        public Node(char c) {
            this.c = c;
        }
    }

    private Node root = new Node('a');

    /**
     * Initialize your data structure here.
     */
    public Trie() {

    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            Node nextNode = curNode.nodes[word.charAt(i) - 'a'];
            if (nextNode == null) {
                curNode.nodes[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                nextNode = curNode.nodes[word.charAt(i) - 'a'];
            }
            curNode = nextNode;
        }
        curNode.isExist = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            if (curNode == null) {
                return false;
            }
            curNode = curNode.nodes[word.charAt(i) - 'a'];
        }

        return curNode != null && curNode.isExist;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curNode == null) {
                return false;
            }
            curNode = curNode.nodes[prefix.charAt(i) - 'a'];
        }
        ///// can be replaced by "return curNode != null;".
        if (curNode == null) {
            return false;
        }
        if (curNode.isExist) {
            return true;
        }
        for (Node node : curNode.nodes) {
            if (node != null) {
                return true;
            }
        }
        return false;
        ///// 
    }
}
