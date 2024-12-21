package V.ValidPalindromeII_680;

/**
 * Time Complexity: O(s.length())
 * Auxiliary Space Complexity: O(1)
 * Runtime: 5ms
 * Rank: 91.47%
 */

public class Solution1 {
    public boolean validPalindrome(String s) {
        char[] cs = s.toCharArray();
        int i = 0;
        int j = cs.length - 1;
        while (i < j) {
            if (cs[i] != cs[j]) {
                return isPalindrome(cs, i, j - 1) || isPalindrome(cs, i + 1, j);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPalindrome(char[] cs, int i, int j) {
        while (i < j) {
            if (cs[i] != cs[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}