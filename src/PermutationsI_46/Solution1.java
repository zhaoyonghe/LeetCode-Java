package PermutationsI_46;
/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n * n!)
 * $$ Space Complexity: O(n * n!)
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        construct(nums, 0, res);
        return res;
    }

    private void construct(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(a2l(nums));
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            construct(nums, i+1, res);
            swap(nums, i, j);
        }
    }

    private List<Integer> a2l(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n: nums) {
            res.add(n);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
