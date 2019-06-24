package PermutationsII;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
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
			List<Integer> usedInt = new ArrayList<>();
			for (int i = start; i < nums.length; i++) {
				// do not do useless swap
				/**
				 * if(start != i && nums[start] == nums[i]){ continue; }
				 **/
				// do not do swap that has been done
				if (usedInt.contains(nums[i])) {
					continue;
				}
				swap(nums, start, i);
				permuteUnique(nums, start + 1, list);
				swap(nums, start, i);
				usedInt.add(nums[i]);
			}
		}

	}

	public void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
