package DecodeWays_91;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 94.23%
 */

public class Solution2 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return s.equals("0") ? 0 : 1;
        }

        int a = 0, b = 0;
        a = s.charAt(0) == '0' ? 0 : 1;
        b = (s.charAt(1) == '0' ? 0 : a) + (isabGE10orLE26(s.charAt(0), s.charAt(1)) ? 1 : 0);

        for (int i = 2; i < s.length(); i++) {
            int tmp = (s.charAt(i) == '0' ? 0 : b) + (isabGE10orLE26(s.charAt(i-1),s.charAt(i)) ? a : 0);
            a = b;
            b = tmp;
        }
        return b;
    }

    // Check whether or not ab is 10 <= ab <= 26?
    private boolean isabGE10orLE26(char a, char b) {
        return a == '1' || (a == '2' && b <= '6');
    }
}
