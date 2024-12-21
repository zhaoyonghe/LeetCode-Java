package S.SingleNumberI_136;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res ^= n;
        }
        return res;
    }
}
