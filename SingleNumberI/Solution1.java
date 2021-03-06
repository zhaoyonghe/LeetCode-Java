package SingleNumberI;

import java.util.HashMap;

/**
 * Assume n is the length of integer array nums.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 10ms
 * Rank: 32.56%
 */
public class Solution1 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], 1);
            }
        }
        return (int) map.keySet().toArray()[0];
    }

}
