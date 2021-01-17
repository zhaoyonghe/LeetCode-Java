package ThreeSumClosest;

import java.util.Arrays;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 12ms
 * Rank: 82.59%
 */

class Solution1 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int result = 0;

        int i = 0;

        while (i < n - 2) {
            int start = i + 1;
            int end = n - 1;
            int tar = target - nums[i];
            while (start < end) {
                int diff = Math.abs(nums[start] + nums[end] - tar);
                if (diff < minDiff) {
                    minDiff = diff;
                    result = nums[start] + nums[end] + nums[i];
                    if (diff == 0) {
                        return result;
                    }
                }

                if (nums[start] + nums[end] > tar) {
                    end -= 1;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end -= 1;
                    }
                } else {
                    // nums[start] + nums[end] < tar
                    start += 1;
                    while (start < end && nums[start] == nums[start - 1]) {
                        start += 1;
                    }
                }
            }

            i += 1;
            while (i < n - 2 && nums[i] == nums[i - 1]) {
                i += 1;
            }
        }

        return result;
    }
}
