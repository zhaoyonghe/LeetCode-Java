package WordSearchII_212;

import java.util.*;

/**
 * $$ Assume board.length is m, board[0].length is n, amount of chars in words is k.
 * $$ Time Complexity: O(m^2 * n^2 + k)
 * $$ Space Complexity: O(m * n + k)
 */
public class Solution1 {
    private int m;
    private int n;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        this.m = board.length;
        this.n = board[0].length;

        boolean[][] visited = new boolean[this.m][this.n];

        for (String word : words) {
            trie.insert(word);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                dfs(board, visited, i, j, sb, trie.root, set);
            }
        }

        list.addAll(set);
        return list;
    }

    public void dfs(char[][] board, boolean[][] visited, int i, int j, StringBuilder cur, Node node, Set<String> list) {
        if (i < 0 || i >= this.m || j < 0 || j >= this.n || visited[i][j]) {
            return;
        }
        node = node.nodes[board[i][j]-'a'];
        if (node == null) {
            return;
        }

        visited[i][j] = true;
        cur.append(board[i][j]);
        if (node.isExist) {
            list.add(cur.toString());
        }

        dfs(board, visited, i - 1, j, cur, node, list);
        dfs(board, visited, i + 1, j, cur, node, list);
        dfs(board, visited, i, j - 1, cur, node, list);
        dfs(board, visited, i, j + 1, cur, node, list);

        cur.deleteCharAt(cur.length()-1);
        visited[i][j] = false;

        return;
    }

    private class Node {
        public boolean isExist = false;
        public Node[] nodes = new Node[26];
    }

    private class Trie {
        public final Node root = new Node();

        public void insert(String word) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                Node nextNode = curNode.nodes[word.charAt(i) - 'a'];
                if (nextNode == null) {
                    curNode.nodes[word.charAt(i) - 'a'] = new Node();
                    nextNode = curNode.nodes[word.charAt(i) - 'a'];
                }
                curNode = nextNode;
            }
            curNode.isExist = true;
        }
    }
}
