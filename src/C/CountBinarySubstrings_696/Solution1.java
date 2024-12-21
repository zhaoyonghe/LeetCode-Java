package C.CountBinarySubstrings_696;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 6ms
 * Rank: 99.25%
 */
public class Solution1 {
    // Important constraints:
    // 1. s[i] is either '0' or '1'.
    public int countBinarySubstrings(String s) {
        int n = s.length();
        if (n == 1) {
            return 0;
        }
        char[] cs = s.toCharArray();
        char cur = cs[0];
        int curCnt = 1, lastCnt = 0, res = 0;
        for (int i = 1; i < n; i++) {
            if (cs[i] == cur) {
                curCnt++;
                continue;
            }
            // cs[i] != cur
            res += Math.min(lastCnt, curCnt);
            cur = cs[i];
            lastCnt = curCnt;
            curCnt = 1;
        }
        return res + Math.min(lastCnt, curCnt);
    }
}