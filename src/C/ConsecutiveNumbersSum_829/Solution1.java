package C.ConsecutiveNumbersSum_829;

/**
 * Time Complexity: O(n ^ 0.5)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 93.98%
 */

public class Solution1 {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int tn = n * 2;
        for (int k = 1; k * k < tn; k++) {
            if (tn % k != 0) {
                continue;
            }
            int ak = tn / k;
            res += (k % 2 == 1) ? 1 : 0;
            res += (ak % 2 == 1) ? 1 : 0;
        }
        return res;
    }
}