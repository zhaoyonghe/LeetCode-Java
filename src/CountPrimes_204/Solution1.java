package CountPrimes_204;

/**
 * $$ Time Complexity: O((n * n ^ 1 / 2) / logn) nearly O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int countPrimes(int n) {
        if (n == 0) {
            return 0;
        }
        // records[i] is true when it is not a prime
        boolean[] records = new boolean[n];
        int stop = (int) Math.floor(Math.sqrt(n));
        for (int i = 2; i <= stop; i++) {
            if (!records[i]) {
                for (int temp = i + i; temp < n; temp += i) {
                    records[temp] = true;
                }
            }
        }
        // collect result
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!records[i]) {
                count += 1;
            }
        }
        return count;
    }
}
