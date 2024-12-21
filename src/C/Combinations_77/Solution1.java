package C.Combinations_77;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is nums.length.
 * Time Complexity: O(C_n^k * k)
 * Space Complexity: O(C_n^k * k)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        construct(1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void construct(int i, int k, int n, List<Integer> cur, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (n - i + 1 < k) {
            return;
        }

        construct(i + 1, k, n, cur, res);

        cur.add(i);
        construct(i + 1, k - 1, n, cur, res);
        cur.remove(cur.size() - 1);
    }
}
