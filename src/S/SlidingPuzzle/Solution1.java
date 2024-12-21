package S.SlidingPuzzle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 17ms
 * Rank: 37.91%
 */

public class Solution1 {
    public int slidingPuzzle(int[][] board) {
        HashMap<String, HashSet<String>> g = new HashMap<>();
        char[] arr = new char[]{'0', '1', '2', '3', '4', '5'};
        buildGraph(g, 0, arr);

        // bfs
        HashSet<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        int dist = -1;
        queue.offer(getString(board));

        while (!queue.isEmpty()) {
            int sz = queue.size();
            dist += 1;
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                // System.out.println(cur);
                visited.add(cur);
                if (cur.equals("123450")) {
                    return dist;
                }
                for (String s : g.get(cur)) {
                    if (!visited.contains(s)) {
                        queue.offer(s);
                        visited.add(s);
                    }
                }
            }
        }

        return -1;
    }

    public void buildGraph(HashMap<String, HashSet<String>> g, int start, char[] arr) {
        if (start == 5) {
            g.put(new String(arr), get(arr));
            return;
        }

        for (int i = start; i < 6; i++) {
            swap(arr, start, i);
            buildGraph(g, start + 1, arr);
            swap(arr, start, i);
        }
    }

    public String getString(int[][] board) {
        char[] arr = new char[6];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i * 3 + j] = (char) ('0' + board[i][j]);
            }
        }
        return new String(arr);
    }

    public HashSet<String> get(char[] arr) {
        HashSet<String> temp = new HashSet<String>();

        int i = 0;
        for (i = 0; i < 6; i++) {
            if (arr[i] == '0') {
                break;
            }
        }

        int r = i / 3;
        int c = i % 3;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int j = 0; j < 4; j++) {
            int rr = r + dir[j][0];
            int cc = c + dir[j][1];
            if (rr >= 0 && rr < 2 && cc >= 0 && cc < 3) {
                swap(arr, i, rr * 3 + cc);
                temp.add(new String(arr));
                swap(arr, i, rr * 3 + cc);
            }
        }

        return temp;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
