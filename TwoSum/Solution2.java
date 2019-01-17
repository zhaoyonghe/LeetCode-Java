package TwoSum;
/**
 * Assume n is the length of nums.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 7ms
 * Rank: 59.68%
 */
import java.util.HashMap;
import java.util.ArrayList;

public class Solution2 {

	public int[] twoSum(int[] nums, int target) {

		ArrayList<Integer> indexes = null;

		// key: integer in nums
		// value: indexes of that integer in nums
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		// construct the map
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.get(nums[i]).add(i);
				/*
				indexes = map.get(nums[i]);
				indexes.add(i);
				map.put(nums[i], indexes);
				*/
			} else {
				indexes = new ArrayList<Integer>();
				indexes.add(i);
				map.put(nums[i], indexes);
			}
		}

		// find the result
		for (int i = 0; i < nums.length; i++) {
			int tofind = target - nums[i];
			if (map.containsKey(tofind)) {
				if (tofind == nums[i]) {
					if (map.get(tofind).size() == 1) {
						continue;
					} else {
						return new int[] { i, map.get(tofind).get(1) };
					}
				} else {
					return new int[] { i, map.get(tofind).get(0) };
				}
			}
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(1, 3);
		map.put(2, 4);
		map.put(1, 5);
		System.out.println(map);
	}

}
