package M.MaximumGap_164;

import java.util.Arrays;

/**
 * $$ Time Complexity: O(nums.length)
 * $$ Space Complexity: O(nums.length)
 */
public class Solution1 {
    // bucket sort
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }
        int min = nums[0], max = nums[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < n; i++) {
            nums[i] -= min;
        }

        int range = max - min;
        int gapCount = n - 1;
        int minmaxGap = range / gapCount + (range % gapCount == 0 ? 0 : 1); // ceil(range/gapCount)
        if (minmaxGap == 0) {
            // all numbers are the same
            return 0;
        }
        // numbers land in the same bucket cannot have gap more than minmaxGap, so we can ignore numbers in the same bucket
        int[][] buckets = new int[range / minmaxGap + 1][2]; // buckets.length <= 2n

        for (int i = 0; i < buckets.length; i++) {
            buckets[i][0] = -1;
            buckets[i][1] = -1;
        }

        for (int num : nums) {
            int bucketIndex = num / minmaxGap;
            if (buckets[bucketIndex][0] == -1 && buckets[bucketIndex][1] == -1) {
                buckets[bucketIndex][0] = num;
                buckets[bucketIndex][1] = num;
                continue;
            }
            buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num);
            buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num);
        }

        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i][0] == -1 && buckets[i][1] == -1) {
                continue;
            }
            arr.add(buckets[i]);
        }

        int maxGap = minmaxGap;
        for (int i = 1; i < arr.size(); i++) {
            maxGap = Math.max(maxGap, arr.get(i)[0] - arr.get(i - 1)[1]);
        }
        return maxGap;
    }
}