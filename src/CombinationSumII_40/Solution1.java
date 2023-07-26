package CombinationSumII_40;

import java.util.*;

/**
 * $$ Assume candidates.length is n, target is t.
 * $$ Time Complexity: O(n ^ t)
 * $$ Space Complexity: O(n ^ t)
 */
public class Solution1 {
    class Num {
        int num;
        int count;
        Num(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: candidates) {
            map.compute(num, (k,v)->v==null?1:v+1);
        }
        Num[] nums = new Num[map.size()];
        int i = 0;
        for (Map.Entry<Integer,Integer> en: map.entrySet()) {
            nums[i] = new Num(en.getKey(),en.getValue());
            i++;
        }

        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, Num[] nums, int i, int target, List<Integer> cur) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i == nums.length) {
            return;
        }

        helper(res, nums, i+1, target, cur);
        int count = 1;
        for (; count <= nums[i].count && count * nums[i].num <= target; count++) {
            cur.add(nums[i].num);
            helper(res, nums, i+1, target-count * nums[i].num, cur);
        }
        for (int cnt = 0; cnt < count-1; cnt++) {
            cur.remove(cur.size()-1);
        }
    }
}