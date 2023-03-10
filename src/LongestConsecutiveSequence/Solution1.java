package LongestConsecutiveSequence;

import java.util.HashMap;

/**
 * Assume n is nums.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 10ms
 * Rank: 43.18%
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int le = map.getOrDefault(num - 1, 0);
            int ri = map.getOrDefault(num + 1, 0);
            if (le == 0 && ri == 0) {
                // num is single
                map.put(num, 1);
            } else if (le == 0) {
                // can form with right
                map.put(num + ri, ri + 1);
                map.put(num, ri + 1);
            } else if (ri == 0) {
                // can form with left
                map.put(num - le, le + 1);
                map.put(num, le + 1);
            } else {
                // bridge
                map.put(num - le, ri + le + 1);
                map.put(num + ri, ri + le + 1);
                map.put(num, 1);
            }
        }

        int max = 0;
        for (int num : map.values()) {
            max = Math.max(max, num);
        }
        return max;
    }
}
