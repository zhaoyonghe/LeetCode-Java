package SubsetsI_78;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(2 ^ n * n)
 * Space Complexity: O(2 ^ n * n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        construct(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void construct(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        // Do not add current value nums[i].
        construct(nums, i+1, cur, res);
        // Add current value nums[i].
        cur.add(nums[i]);
        construct(nums, i+1, cur, res);
        cur.remove(cur.size()-1);
    }
}
