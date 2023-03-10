package ThreeSumClosest_16;

import java.util.Arrays;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 2)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 98.69%
 */

class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        // Important constraints:
        // 3 <= nums.length <= 1000 (input is always valid, not null)
        // -10^4 <= target <= 10^4 (sum will never overflow)
        int res = nums[0] + nums[1] + nums[2];
        if (res == target) {
            return res;
        }
        Arrays.sort(nums);
        int i = 0;
        int n = nums.length;

        while (i < n - 2) {
            while (i > 0 && i < n - 2 && nums[i-1]==nums[i]) {
                i++;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    if (Math.abs(res - target) > sum - target) {
                        res = sum;
                    }
                    k--;
                } else if (sum < target) {
                    if (Math.abs(res - target) > target - sum) {
                        res = sum;
                    }
                    j++;
                } else {
                    return sum;
                }
            }
            i++;
        }
        return res;
    }
}
