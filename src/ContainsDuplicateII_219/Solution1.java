package ContainsDuplicateII_219;

import java.util.HashMap;

/**
 * $$ Time Complexity: O(nums.length)
 * $$ Space Complexity: O(nums.length)
 */
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) + k >= i) {
                // [hidden condition][0 <=] i - map.get(nums[i]) <= k
                // distance is smaller than k
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
