package PermutationInString_567;


/**
 * $$ Assume s1.length() is n; s2.length() is m.
 * $$ Time Complexity: O(n + m)
 * $$ Space Complexity: O(1)
 */
public class Solution1 {
    public boolean checkInclusion(String s1, String s2) {
        int[] map = new int[128];
        for (char c : s1.toCharArray()) {
            map[c]++;
        }
        int start = 0;
        int end = start + s1.length() - 1;
        for (int i = 0; i < end && i < s2.length(); i++) {
            map[s2.charAt(i)]--;
        }
        for (; end < s2.length(); start++, end++) {
            if (start > 0) {
                map[s2.charAt(start - 1)]++;
            }
            map[s2.charAt(end)]--;
            if (allzero(map)) {
                return true;
            }
        }
        return false;
    }

    private boolean allzero(int[] map) {
        for (int count : map) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}