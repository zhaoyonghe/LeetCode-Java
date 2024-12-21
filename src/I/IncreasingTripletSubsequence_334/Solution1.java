package I.IncreasingTripletSubsequence_334;

/**
 * Assume the length of nums is n;
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.77%
 */
public class Solution1 {
    public boolean increasingTriplet(int[] nums) {
        int a = nums[0], b = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= a) {
                a = nums[i];
                continue;
            }
            // a < nums[i]
            if (nums[i] <= b) {
                b = nums[i];
                continue;
            }
            // a < b < nums[i]
            return true;
        }
        return false;
    }
}
