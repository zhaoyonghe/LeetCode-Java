package SubsetsI;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(2 ^ n * n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 89.95%
 */
public class Solution2 {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < (1 << nums.length); i++) {
			List<Integer> subset = new ArrayList<Integer>();
			for (int j = 0; j < nums.length; j++) {
				if ((i & (1 << j)) != 0) {
					subset.add(nums[j]);
				}
			}
			list.add(subset);
		}
		return list;
	}
}
