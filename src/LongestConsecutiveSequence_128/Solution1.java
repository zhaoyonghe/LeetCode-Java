package LongestConsecutiveSequence_128;

import java.util.*;

/**
 * $$ Assume n is nums.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Boolean> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, false);
        }
        int res = 1;
        for (int n: nums) {
            if (map.get(n)) {
                // expanded
                continue;
            }
            res = Math.max(res, expand(map, n));
        }
        return res;
    }

    private int expand(Map<Integer, Boolean> map, int n) {
        int i = n;
        int j = n;
        // i, j will not overflow
        while (map.containsKey(i)) {
            map.put(i, true);
            i--;
        }
        while (map.containsKey(j)) {
            map.put(j, true);
            j++;
        }
        return j - i - 1;
    }
}
