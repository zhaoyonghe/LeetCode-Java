package SubarraySumEqualsK;

import java.util.HashMap;
/**
 * Assume nums.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 19ms
 * Rank: 97.39%
 */
public class Solution1 {
	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int[] prefixSum = new int[n + 1];

		// calculate the prefix sum
		// O(n)
		for (int i = 0; i < n; i++) {
			prefixSum[i + 1] = prefixSum[i] + nums[i];
		}

		// O(n)
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = n; i >= 0; i--) {
			count += (map.getOrDefault(k + prefixSum[i], 0));
			map.compute(prefixSum[i], (key, val) -> (val == null) ? 1 : val + 1);
		}

		return count;
	}
}
