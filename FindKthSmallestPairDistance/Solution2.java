package FindKthSmallestPairDistance;

import java.util.Arrays;

/**
 * Assume range is max(nums) - min(nums) and n is nums.length.
 * Time Complexity: O(n * log(n) + n * log(range))
 * Space Complexity: O(1)
 * Runtime: 15ms
 * Rank: 40.21%
 */
class Solution2 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            // the amount of distance pairs that is less or equals to mid
            int count = 0;
            int j = 1;

            for (int i = 0; i < nums.length - 1; i++) {
                j = Math.max(j, i + 1);
                while (j < nums.length && nums[i] + mid >= nums[j]) {
                    j += 1;
                }
                count += (j - i - 1);
            }

            if (count < k) {
                low = mid + 1;
            } else {
                // count >= k
                high = mid;
                // mid may be the result
                // we need to check whether or not count >= k when distance is mid - 1
                // if count < k, mid is the answer
                // if count >= k, distance smaller than mid - 1 should be the answer
            }
        }

        // low == high
        return low;
    }
}