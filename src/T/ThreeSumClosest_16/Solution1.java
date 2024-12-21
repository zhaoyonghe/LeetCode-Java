package T.ThreeSumClosest_16;

import java.util.Arrays;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n ^ 2)
 * $$ Auxiliary Space Complexity: O(1)
 */

class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target) {
                    if (sum - target < Math.abs(diff)) {
                        diff = sum - target;
                    }
                    k--;
                } else if (sum < target) {
                    if (target - sum < Math.abs(diff)) {
                        diff = sum - target;
                    }
                    j++;
                } else {
                    return sum;
                }
            }
        }
        return target + diff;
    }
}
