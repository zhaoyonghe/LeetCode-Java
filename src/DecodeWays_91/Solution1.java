package DecodeWays_91;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 94.23%
 */
public class Solution1 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return s.equals("0") ? 0 : 1;
        }

        int[] dp = new int[len];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1] = (s.charAt(1) == '0' ? 0 : dp[0]) + (isabGE10orLE26(s.charAt(0), s.charAt(1)) ? 1 : 0);

        for (int i = 2; i < len; i++) {
            dp[i] = (s.charAt(i) == '0' ? 0 : dp[i-1]) + (isabGE10orLE26(s.charAt(i-1),s.charAt(i)) ? dp[i-2] : 0);
        }
        return dp[len-1];
    }

    // Check whether or not ab is 10 <= ab <= 26?
    private boolean isabGE10orLE26(char a, char b) {
        return a == '1' || (a == '2' && b <= '6');
    }
}
