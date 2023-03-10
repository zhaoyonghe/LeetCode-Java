package MissingNumber;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.21%
 */
public class Solution1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        long sum = ((long) n * ((long) n + 1)) >> 1;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return (int) sum;
    }

}
