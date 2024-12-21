package C.CombinationSum_39;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume candidates.length is n, target is t.
 * $$ Time Complexity: O(n ^ t)
 * $$ Space Complexity: O(n ^ t)
 */
public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> record = new ArrayList<>();
        List<List<List<Integer>>> tmp = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            record.add(new ArrayList<>());
            tmp.add(new ArrayList<>());
        }

        for (int candidate : candidates) {
            for (int i = 1; i * candidate <= target; i++) {
                for (int j = 1; j <= target - i * candidate; j++) {
                    for (List<Integer> cur : record.get(j)) {
                        List<Integer> next = new ArrayList<>(cur);
                        for (int k = 0; k < i; k++) {
                            next.add(candidate);
                        }
                        tmp.get(j + i * candidate).add(next);
                    }
                }
            }

            for (int i = 1; i <= target; i++) {
                record.get(i).addAll(tmp.get(i));
                tmp.get(i).clear();
            }

            for (int i = 1; i * candidate <= target; i++) {
                List<Integer> multi = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    multi.add(candidate);
                }
                record.get(i * candidate).add(multi);
            }
        }

        return record.get(target);
    }
}