package PartitionToKEqualSumSubsets;

/**
 * Assume the nums.length is n.
 * Time Complexity: O(k ^ n)
 * Space Complexity: O(n + k)
 * Runtime: 1673ms
 * Rank: 5.14%
 */
public class Solution1 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        return partition(new int[k], nums, 0, sum / k);
    }

    public boolean partition(int[] sums, int[] nums, int i, int sum) {
        if (i == nums.length) {
            return true;
        }

        for (int j = 0; j < sums.length; j++) {
            if (sums[j] + nums[i] <= sum) {
                sums[j] += nums[i];
                if (partition(sums, nums, i + 1, sum)) {
                    return true;
                } else {
                    sums[j] -= nums[i];
                    continue;
                }
            }
        }

        return false;
    }
}
