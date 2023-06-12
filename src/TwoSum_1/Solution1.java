package TwoSum_1;

import java.util.HashMap;
import java.util.Map;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i= 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }
}
