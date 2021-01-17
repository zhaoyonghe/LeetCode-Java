package WordSearchII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<String> findWords(char[][] board, String[] words) {
        Arrays.sort(words);
        Trie trie = new Trie();

        List<String> list = new ArrayList<String>();

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int ii = words.length - 1; ii >= 0; ii--) {
            if (trie.startsWith(words[ii])) {
                list.add(words[ii]);
            } else {
                outside:
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (dfs(board, visited, words[ii], i, j, 0)) {
                            list.add(words[ii]);
                            trie.insert(words[ii]);
                            break outside;
                        }
                    }
                }
            }
        }

        return list;

    }

    public boolean dfs(char[][] board, boolean[][] visited, String s, int i, int j, int k) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        if (visited[i][j] || board[i][j] != s.charAt(k)) {
            return false;
        }

        if (k == s.length() - 1 && board[i][j] == s.charAt(k)) {
            return true;
        }

        visited[i][j] = true;

        boolean find = dfs(board, visited, s, i - 1, j, k + 1) || dfs(board, visited, s, i + 1, j, k + 1)
                || dfs(board, visited, s, i, j - 1, k + 1) || dfs(board, visited, s, i, j + 1, k + 1);

        visited[i][j] = false;

        return find;
    }

    class Trie {

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
                // System.out.println(curNode.c);
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
            return curNode != null;
        }
    }

}
