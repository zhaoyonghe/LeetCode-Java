package C.ContainsDuplicateIII;

import java.util.TreeSet;

/**
 * Assume n is nums.length.
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
 * Runtime: 53ms
 * Rank: 32.96%
 */

class Solution2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) {
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Integer lower = set.floor(nums[i]);
            if (lower != null && Math.abs((long) lower - (long) nums[i]) <= (long) t) {
                return true;
            }

            Integer higher = set.ceiling(nums[i]);
            if (higher != null && Math.abs((long) higher - (long) nums[i]) <= (long) t) {
                return true;
            }
            set.add(nums[i]);

            if (i >= k) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }
}
