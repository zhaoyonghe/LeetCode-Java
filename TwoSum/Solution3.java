package TwoSum;
/**
 * Assume n is the length of nums.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 75.81%
 */
import java.util.HashMap;

public class Solution3 {

	public int[] twoSum(int[] nums, int target) {
		// In previous solution, 
		// we record the indexes of duplicate numbers that appear in nums by array list,
		// but as a matter of fact,
		// the value of this hash map need not to be an array list,
		// because we only need one applicable indexes pair, 
		// so for each number value, we only need one index of it.
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
