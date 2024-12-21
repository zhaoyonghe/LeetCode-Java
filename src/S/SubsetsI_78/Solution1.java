package S.SubsetsI_78;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(2 ^ n * n)
 * $$ Space Complexity: O(2 ^ n * n)
 */
public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] nums, int i, List<List<Integer>> res, List<Integer> cur) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        helper(nums, i + 1, res, cur);
        cur.add(nums[i]);
        helper(nums, i + 1, res, cur);
        cur.remove(cur.size() - 1);
    }
}
