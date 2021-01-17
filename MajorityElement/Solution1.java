package MajorityElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(nums.length)
 * Runtime: 14ms
 * Rank: 40.28%
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> (v == null ? 1 : v + 1));
        }
        int k = nums.length / 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > k) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
