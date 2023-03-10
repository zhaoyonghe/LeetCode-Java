package SubsetsII_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(2 ^ n * n)
 * Space Complexity: O(2 ^ n * n)
 * Runtime: 1ms
 * Rank: 99.49%
 */
public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        construct(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void construct(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        int next = i + 1;
        while (next < nums.length && nums[next] == nums[i]) {
            next++;
        }

        construct(nums, next, cur, res);
        for (int j = i; j < next; j++) {
            cur.add(nums[j]);
            construct(nums, next, cur, res);
        }
        for (int j = i; j < next; j++) {
            cur.remove(cur.size()-1);
        }
    }
}
