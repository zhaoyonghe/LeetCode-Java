package DominoAndTrominoTiling_790;

/**
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // a[0] = 1
        // a[n] = a[n-1] + a[n-2] + 2 * (a[n-3] + ... + a[0])
        long MOD = 1000000007;
        long minus1 = 2, minus2 = 1, sum = 1;
        for (int i = 3; i <= n; i++) {
            long cur = (minus1 + minus2 + 2 * sum) % MOD;
            sum += minus2;
            minus2 = minus1;
            minus1 = cur;
        }
        return (int) minus1;
    }
}
