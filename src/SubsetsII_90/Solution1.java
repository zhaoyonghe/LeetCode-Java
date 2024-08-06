package SubsetsII_90;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(2 ^ n * n)
 * $$ Space Complexity: O(2 ^ n * n)
 */
public class Solution1 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }
        Num[] ns = new Num[map.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            ns[i] = new Num(en.getKey(), en.getValue());
            i++;
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(ns, 0, res, new ArrayList<>());
        return res;
    }

    private void helper(Num[] nums, int i, List<List<Integer>> res, List<Integer> cur) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        helper(nums, i + 1, res, cur);
        for (int cnt = 0; cnt < nums[i].count; cnt++) {
            cur.add(nums[i].num);
            helper(nums, i + 1, res, cur);
        }
        for (int cnt = 0; cnt < nums[i].count; cnt++) {
            cur.remove(cur.size() - 1);
        }
    }

    private class Num {
        int num;
        int count;

        Num(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
