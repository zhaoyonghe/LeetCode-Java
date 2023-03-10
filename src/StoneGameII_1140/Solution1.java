package StoneGameII_1140;

import java.util.stream.IntStream;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n ^ 2)
 * Runtime: 4ms
 * Rank: 64.81%
 */

public class Solution1 {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n+1];
        int[] suffixSum = new int[n];
        suffixSum[n-1]=piles[n-1];
        for (int i = n-2; i >=0;i--) {
            suffixSum[i] = suffixSum[i+1]+piles[i];
        }
        int diff = solve(piles,0,1,memo,suffixSum);
        return (suffixSum[0]+diff)/2;
    }

    private int solve(int[] piles, int i, int m, Integer[][] memo, int[] suffixSum) {
        if (i >= piles.length) {
            return 0;
        }
        if (memo[i][m] != null) {
            return memo[i][m];
        }
        if (piles.length <= i+2*m) {
            memo[i][m] = suffixSum[i];
            return memo[i][m];
        }
        int a = 0;
        Integer res = null;
        for (int take = 1; take<=2*m;take++){
            a += piles[i+take-1];
            int tmp = a-solve(piles, i+take, Math.max(m,take), memo, suffixSum);
            res = res==null? tmp: Math.max(res,tmp);
        }
        memo[i][m] = res;
        return memo[i][m];
    }
}