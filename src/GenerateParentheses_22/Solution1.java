package GenerateParentheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Time Complexity: O(4^n/n^(1/2))
 * $$ Space Complexity: O(n)
 */

class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(new char[n*2], 0, n, n, res);
        return res;
    }

    private void helper(char[] cur, int i, int left, int right, List<String> res) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        // left <= right
        if (i == cur.length) {
            // Also means left == right == 0.
            res.add(new String(cur));
            return;
        }
        cur[i] = '(';
        helper(cur, i+1, left-1, right, res);
        cur[i] = ')';
        helper(cur, i+1, left, right-1, res);
    }
}