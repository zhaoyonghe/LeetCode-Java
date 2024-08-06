package LongestCommonPrefix_14;

/**
 * $$ Assume there are n characters in strs.
 * $$ Time Complexity: O(n)
 * $$ Auxiliary Space Complexity: O(1)
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        int j = 0;
        all:
        for (; ; j++) {
            for (String str : strs) {
                if (j == str.length() || str.charAt(j) != strs[0].charAt(j)) {
                    break all;
                }
            }
        }
        return j == 0 ? "" : strs[0].substring(0, j);
    }
}
