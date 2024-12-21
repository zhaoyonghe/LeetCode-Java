package V.ValidParenthesisString_678;

/**
 * $$ Assume s.length() is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */

public class Solution2 {
    public boolean checkValidString(String s) {
        int lo = 0;
        int hi = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                lo++;
                hi++;
            } else if (c == ')') {
                hi--;
                if (hi < 0) {
                    return false;
                }
                lo = Math.max(0, lo - 1);
            } else {
                // c == '*'
                hi++;
                lo = Math.max(0, lo - 1);
            }
        }
        return lo == 0;
    }
}