package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 100.00%
 */

class Solution1 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] s = new char[n * 2];
        s[0] = '(';
        generateParenthesis(1, 0, n, s, result);
        return result;
    }

    public void generateParenthesis(int left, int right, int n, char[] s, List<String> result) {
        // left is the number of '('
        // right is the number of ')'
        // left should be always greater or equals than right
        if (left == n && right == n) {
            result.add(new String(s));
            return;
        }

        if (left < n) {
            s[left + right] = '(';
            generateParenthesis(left + 1, right, n, s, result);
        }

        if (left > right) {
            s[left + right] = ')';
            generateParenthesis(left, right + 1, n, s, result);
        }
    }
}