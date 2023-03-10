package DeleteAndEarn_740;

/**
 * Assume n is nums.length, m is max(nums)-min(nums).
 * Time Complexity: O(max(m, n))
 * Space Complexity: O(m)
 * Runtime: 2ms
 * Rank: 73.53%
 */

public class Solution1 {
    public int deleteAndEarn(int[] nums) {
        int[] houses = new int[10001];
        for (int x : nums) {
            houses[x] += x;
        }
        int prev = houses[0];
        int skip = 0;
        for (int i = 1; i < 10001; i++) {
            int tmp = Math.max(houses[i] + skip, prev);
            skip = prev;
            prev = tmp;
        }
        return prev;
    }
}
