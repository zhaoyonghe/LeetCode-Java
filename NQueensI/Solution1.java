package NQueensI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 93.02%
 */
public class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] avacol = new boolean[n];
        solve(new int[n], avacol, 0, n, result);
        return result;
    }

    public void solve(int[] pos, boolean[] avacol, int i, int n, List<List<String>> result) {
        if (i == n) {
            List<String> sol = new ArrayList<>();
            for (int k = 0; k < n; k++) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[pos[k]] = 'Q';
                sol.add(new String(row));
            }
            result.add(sol);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!avacol[col]) {
                boolean flag = false;
                for (int k = 0; k < i; k++) {
                    if (Math.abs(k - i) == Math.abs(pos[k] - col)) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    continue;
                }
                avacol[col] = true;
                pos[i] = col;
                solve(pos, avacol, i + 1, n, result);
                avacol[col] = false;
            }
        }
    }
}
