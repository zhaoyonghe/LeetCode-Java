package PermutationsII_47;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n * n!)
 * $$ Space Complexity: O(n * n!)
 */
public class Solution1 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        construct(nums, 0, res);
        return res;
    }

    private void construct(int[] nums, int i, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(a2l(nums));
            return;
        }
        // Use the constraint: -10 <= nums[i] <= 10.
        boolean[] set = new boolean[21];
        for (int j = i; j < nums.length; j++) {
            if (isUsed(nums[j], set)) {
                continue;
            }
            use(nums[j], set);
            swap(nums, i, j);
            construct(nums, i+1, res);
            swap(nums, i, j);
        }
    }

    private void use(int val, boolean[] set) {
        set[val+10]=true;
    }

    private boolean isUsed(int val, boolean[] set) {
        return set[val+10];
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
