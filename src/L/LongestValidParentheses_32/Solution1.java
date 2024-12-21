package L.LongestValidParentheses_32;

/**
 * $$ Assume n is s.length().
 * $$ Time Complexity: O(n ^ 2)
 * $$ Space Complexity: O(1)
 */

class Solution1 {
    public int longestValidParentheses(String s) {
        int n = s.length();

        int maxLen = 0;

        for (int i = 0; i < n - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '(') {
                    left += 1;
                } else {
                    right += 1;
                }

                if (left > right) {
                    continue;
                } else if (left < right) {
                    break;
                } else {
                    // left == right
                    maxLen = Math.max(maxLen, j - i + 1);
                }

            }
        }

        return maxLen;
    }
}