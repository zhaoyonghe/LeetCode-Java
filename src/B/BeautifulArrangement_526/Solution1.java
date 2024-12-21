package B.BeautifulArrangement_526;

/**
 * $$ Time Complexity: O(n!)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int countArrangement(int n) {
        boolean[] inPermutation = new boolean[n + 1];
        int[] res = new int[1];
        helper(0, n, res, inPermutation);
        return res[0];
    }

    private void helper(int cur, int n, int[] res, boolean[] inPermutation) {
        if (cur == n) {
            res[0]++;
            return;
        }
        for (int num = 1; num <= n; num++) {
            if (inPermutation[num]) {
                continue;
            }
            if (num % (cur + 1) != 0 && (cur + 1) % num != 0) {
                continue;
            }
            inPermutation[num] = true;
            helper(cur + 1, n, res, inPermutation);
            inPermutation[num] = false;
        }
    }
}