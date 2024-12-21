package S.SubarraySumEqualsK_560;

import java.util.HashMap;
import java.util.Map;

/**
 * Assume nums.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 16ms
 * Rank: 97.91%
 */
public class Solution1 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int presum = 0;
        for (int n : nums) {
            presum += n;
            res += map.getOrDefault(presum - k, 0);
            map.compute(presum, (key, value) -> value == null ? 1 : value + 1);
        }
        return res;
    }
}
