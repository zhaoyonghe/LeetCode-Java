package G.GasStation_134;

import java.util.Arrays;

/**
 * $$ Assume n is gas.length.
 * $$ Time Complexity: O(n)
 * $$ Auxiliary Space Complexity: O(1)
 */

public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] gasOffset = new int[n];
        for (int i = 0; i < n; i++) {
            gasOffset[i] = gas[i] - cost[i];
        }
        if (Arrays.stream(gasOffset).sum() < 0) {
            return -1;
        }

        int[] res = new int[]{-1, 0};
        int suffixSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum += gasOffset[i];
            if (gas[i] > 0 && suffixSum >= res[1]) {
                res[1] = suffixSum;
                res[0] = i;
            }
        }
        return res[0];
    }
}