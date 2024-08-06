package DesignAddAndSearchWordsDataStructure_211;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume word.length() is n.
 * $$ Constructor Time Complexity: O(1)
 * $$ addWord() Time Complexity: O(n)
 * $$ search() Time Complexity: O(n)
 */
class WordDictionary1 {
    private final Node root = new Node();

    public WordDictionary1() {

    }

    public void addWord(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        // bfs
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);

        for (char c : word.toCharArray()) {
            int sz = q.size();
            for (int x = 0; x < sz; x++) {
                Node cur = q.poll();
                if (c == '.') {
                    for (int i = 0; i < 26; i++) {
                        if (cur.next[i] == null) {
                            continue;
                        }
                        q.offer(cur.next[i]);
                    }
                    continue;
                }
                // c != '.'
                if (cur.next[c - 'a'] == null) {
                    continue;
                }
                q.offer(cur.next[c - 'a']);
            }
        }
        if (q.isEmpty()) {
            return false;
        }
        while (!q.isEmpty()) {
            if (q.poll().isWord) {
                return true;
            }
        }
        return false;
    }

    class Node {
        Node[] next = new Node[26];
        boolean isWord;
    }
}