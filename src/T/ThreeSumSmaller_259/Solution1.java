package T.ThreeSumSmaller_259;

import java.util.Arrays;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 2)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 9ms
 * Rank: 85.85%
 */
public class Solution1 {
    public int threeSumSmaller(int[] nums, int target) {
        // Important constraints:
        // 0 <= nums.length <= 3500 (input is not null)
        // -100 <= nums[i] <= 100 (sum will never overflow)
        if (nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    res += k - j;
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
}