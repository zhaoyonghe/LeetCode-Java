package LongestSubstringWithoutRepeatingCharacter_3;

/**
 * $$ Assume n is the length of s.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean[] map = new boolean[128];
        char[] cs = s.toCharArray();
        int res = 1;
        int start = 0;
        for (int end = 0; end < cs.length; end++) {
            if (map[cs[end]]) {
                while (cs[start] != cs[end]) {
                    map[cs[start]] = false;
                    start++;
                }
                if (start < end) {
                    start++;
                }
            } else {
                map[cs[end]] = true;
            }
            res = Math.max(res, end-start+1);
        }
        return res;
    }
}
