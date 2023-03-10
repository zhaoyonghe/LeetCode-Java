package PalindromeNumber_9;

/**
 * Time Complexity: O(log10(x))
 * Space Complexity: O(log10(x))
 * Runtime: 6ms
 * Rank: 99.99%
 */
public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int a = x;
        int b = 0;
        while (a != 0) {
            b *= 10;
            b += (a % 10);
            a /= 10;
        }
        return x == b;
    }
}
