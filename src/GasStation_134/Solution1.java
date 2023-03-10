package GasStation_134;

/**
 * Assume n is gas.length.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 33.04%
 */

public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        int sum = 0;
        for (int j = 0; j < 2 * n; j++) {
            sum += gas[j % n] - cost[j % n];
            if (sum < 0) {
                sum = 0;
                i = j + 1;
                continue;
            }
            if (i + n - 1 == j) {
                return i;
            }
        }
        return -1;
    }
}