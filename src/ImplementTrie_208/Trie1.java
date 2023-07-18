package ImplementTrie_208;

/**
 * $$ Assume the length of the input word is n.
 * $$ insert Time Complexity: O(n)
 * $$ search Time Complexity: O(n)
 * $$ startsWith Time Complexity: O(n)
 */
public class Trie1 {
    private class Node {
        boolean fullWord;
        Node[] next = new Node[26];
    }

    Node root = new Node();

    public Trie1() {

    }

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c-'a']==null) {
                cur.next[c-'a']=new Node();
            }
            cur = cur.next[c-'a'];
        }
        cur.fullWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c-'a']==null) {
                return false;
            }
            cur = cur.next[c-'a'];
        }
        return cur.fullWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.next[c-'a']==null) {
                return false;
            }
            cur = cur.next[c-'a'];
        }
        return true;
    }
}
