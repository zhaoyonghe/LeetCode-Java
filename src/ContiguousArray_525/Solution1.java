package ContiguousArray_525;

import java.util.HashMap;
import java.util.Map;
/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 42ms
 * Rank: 29.22%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= nums.length <= 10 ^ 5 (null-check is unnecessary)
    public int findMaxLength(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            diff += nums[i] == 0 ? 1 : -1;
            if (diff == 0) {
                res = i + 1;
                continue;
            }
            // diff != 0
            if (map.containsKey(diff)) {
                res = Math.max(res, i - map.get(diff));
                continue;
            }
            // !map.containsKey(diff))
            map.put(diff, i);
        }
        return res;
    }
}