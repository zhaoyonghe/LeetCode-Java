package SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(2 ^ n * n)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 88.95%
 */
public class Solution1 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();

		Arrays.sort(nums);

		List<Integer> uniNums = new ArrayList<>();
		List<Integer> dups = new ArrayList<>();

		int i = 0;
		while (i < nums.length) {
			int count = 1;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] != nums[i]) {
					break;
				}
				count += 1;
			}
			uniNums.add(nums[i]);
			dups.add(count);
			i += count;
		}

		addSubsets(list, uniNums, dups, new ArrayList<Integer>(), 0);
		return list;
	}

	public void addSubsets(List<List<Integer>> list, List<Integer> uniNums, List<Integer> dups, List<Integer> subset,
			int i) {
		if (i == uniNums.size()) {
			List<Integer> csubset = new ArrayList<>();
			for (Integer num : subset) {
				csubset.add(num);
			}
			list.add(csubset);
			return;
		} else {
			addSubsets(list, uniNums, dups, subset, i + 1);
			for (int j = 1; j <= dups.get(i); j++) {
				// j indicates how many uniNums.get(j) will be added into the subset
				subset.add(uniNums.get(i));
				addSubsets(list, uniNums, dups, subset, i + 1);
			}
			subset.subList(subset.size() - dups.get(i), subset.size()).clear();
			return;
		}
	}
}
