package TwoSum;
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 75.81%
 */
import java.util.HashMap;

public class Solution3 {

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				int index = map.get(target - nums[i]);
				if (index != i) {
					return new int[] { i, index };
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
