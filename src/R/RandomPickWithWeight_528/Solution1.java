package R.RandomPickWithWeight_528;

import java.util.Random;

/**
 * $$ Constructor Time Complexity: O(n)
 * $$ pickIndex() Time Complexity: O(logn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    private final int n;
    private final int sum;
    private final int[] pre;
    private final Random rand = new Random();

    public Solution1(int[] w) {
        n = w.length;
        pre = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + w[i];
        }
        sum = pre[n];
    }

    public int pickIndex() {
        int r = rand.nextInt(sum);
        int s = 0;
        int e = n - 1;
        while (s <= e) {
            int m = (s + e) / 2;
            if (r < pre[m]) {
                e = m - 1;
            } else if (pre[m + 1] <= r) {
                s = m + 1;
            } else {
                // pre[i] <= r && r < pre[i + 1]
                return m;
            }
        }
        return -1;
    }
}