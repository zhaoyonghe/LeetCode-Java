package ContainsDuplicateII;

import java.util.HashMap;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(nums.length)
 * Runtime: 11ms
 * Rank: 94.92%
 */
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (map.get(nums[i]) + k >= i) {
                    // [hidden condition][0 <=] i - map.get(nums[i]) <= k
                    // distance is smaller than k
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

}
