package LongestCommonPrefix_14;

/**
 * Time Complexity: O((the length of common prefix + 1) * strs.length)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int j = 0;
        while (true) {
            if (j >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(j);
            int i = 1;
            for (; i < strs.length; i++) {
                if (j < strs[i].length() && c == strs[i].charAt(j)) {
                    continue;
                }
                break;
            }
            if (i != strs.length) {
                // strs[...].charAt(j) are not all equal.
                break;
            }
            j++;
        }
        return strs[0].substring(0, j);
    }
}
