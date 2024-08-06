package CombinationSum_39;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume candidates.length is n, target is t.
 * $$ Time Complexity: O(n ^ t)
 * $$ Space Complexity: O(n ^ t)
 */
public class Solution2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, int i, int target, List<Integer> cur) {
        //System.out.printf("%s %d %d\n", cur, i, target);
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        if (i == candidates.length) {
            return;
        }

        helper(res, candidates, i + 1, target, cur);
        int count = 1;
        for (; count * candidates[i] <= target; count++) {
            cur.add(candidates[i]);
            helper(res, candidates, i + 1, target - count * candidates[i], cur);
        }
        for (int cnt = 0; cnt < count - 1; cnt++) {
            cur.remove(cur.size() - 1);
        }
    }
}