package V.ValidWordAbbreviation_408;

/**
 * Time Complexity: O(min(wl, al))
 * Auxiliary Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 92.03%
 */

public class Solution1 {
    public boolean validWordAbbreviation(String word, String abbr) {
        char[] wc = word.toCharArray();
        char[] ac = abbr.toCharArray();
        int wl = wc.length, al = ac.length;
        int i = 0, j = 0;
        while (i < wl && j < al) {
            if (Character.isLowerCase(ac[j])) {
                if (wc[i] != ac[j]) {
                    return false;
                }
                i++;
                j++;
                continue;
            }
            // abbr consists of lowercase English letters and digits.
            // ac[j] is digit.
            if (ac[j] == '0') {
                return false;
            }
            // All the integers in abbr will fit in a 32-bit integer.
            int num = 0;
            while (j < al && Character.isDigit(ac[j])) {
                num *= 10;
                num += (int) ac[j] - (int) '0';
                j++;
            }
            i += num;
        }
        return i == wl && j == al;
    }
}