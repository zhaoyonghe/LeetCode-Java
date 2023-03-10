package LongestConsecutiveSequence;

import java.util.HashSet;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 7ms
 * Rank: 79.88%
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = 1;
                num += 1;
                while (set.contains(num)) {
                    cur += 1;
                    num += 1;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}
