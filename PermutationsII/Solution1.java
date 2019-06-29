package PermutationsII;

import java.util.ArrayList;
import java.util.List;
/**
 * Assume n is nums.length.
 * Time Complexity: O(n * n!)
 * Space Complexity: O(n ^ 2)
 * Runtime: 6ms
 * Rank: 72.42%
 */
public class Solution1 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permuteUnique(nums, 0, list);
		return list;
	}

	public void permuteUnique(int[] nums, int start, List<List<Integer>> list) {
		if (start == nums.length - 1) {
			List<Integer> tempList = new ArrayList<>(nums.length);
			for (int num : nums) {
				tempList.add(num);
			}
			list.add(tempList);
		} else {
			// start < nums.length
			List<int[]> usedSwap = new ArrayList<>(); // maintain a list cost too much
			for (int i = start; i < nums.length; i++) {
				// do not do useless swap
				if (start != i && nums[start] == nums[i]) {
					continue;
				}
				// do not do swap that has been done
				if (containsUsedSwap(usedSwap, new int[] { nums[start], nums[i] })) {
					continue;
				}
				swap(nums, start, i);
				permuteUnique(nums, start + 1, list);
				swap(nums, start, i);
				usedSwap.add(new int[] { nums[start], nums[i] });
			}
		}

	}

	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public boolean containsUsedSwap(List<int[]> usedSwap, int[] sw) {
		for (int[] s : usedSwap) {
			if (s[0] == sw[0] && s[1] == sw[1]) {
				return true;
			}
		}
		return false;
	}
}
