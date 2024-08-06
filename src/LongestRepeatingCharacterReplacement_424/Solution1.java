package LongestRepeatingCharacterReplacement_424;

/**
 * $$ Assume n is the length of s.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */

public class Solution1 {
    public int characterReplacement(String s, int k) {
        int[] map = new int[128];
        char[] cs = s.toCharArray();
        int res = 1;
        int start = 0;
        for (int end = 0; end < cs.length; end++) {
            map[cs[end]]++;
            while (!ok(map, end - start + 1, k)) {
                map[cs[start]]--;
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    private boolean ok(int[] map, int len, int k) {
        for (int cnt : map) {
            if (cnt == 0) {
                continue;
            }
            if (cnt + k >= len) {
                return true;
            }
        }
        return false;
    }
}