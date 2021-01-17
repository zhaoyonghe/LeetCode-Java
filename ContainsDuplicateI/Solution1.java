package ContainsDuplicateI;

import java.util.HashMap;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(nums.length)
 * Runtime: 12ms
 * Rank: 65.33%
 */
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 0);
            }
        }
        return false;
    }

}
