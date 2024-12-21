package P.PairsOfSongsWithTotalDurationsDivisibleBy60_1010;

/**
 * Time Complexity: O(time.length)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 94.69%
 */

public class Solution1 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        int res = 0;
        for (int t : time) {
            int r = t % 60;
            res += map[(60 - r) % 60];
            map[r]++;
        }
        return res;
    }
}