package MinimumAddToMakeParenthesesValid_921;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int minAddToMakeValid(String s) {
        // Need how many (.
        int left = 0;
        // Need how many ).
        int right = 0;
        for (char c: s.toCharArray()) {
            if (c == '(') {
                // Need one more ) to match this (.
                right++;
                continue;
            }
            if (c == ')') {
                if (right > 0) {
                    // Use this ) to match a previous (.
                    right--;
                    continue;
                }
                // Need one more ( to match this ).
                left++;
            }
        }
        return left + right;
    }
}
