package ContinuousSubarraySum;

import java.util.HashMap;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            for (int i = 1; i < n; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }

        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}
