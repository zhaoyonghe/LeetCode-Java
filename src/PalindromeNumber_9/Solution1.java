package PalindromeNumber_9;

/**
 * $$ Time Complexity: O(log(x))
 * $$ Space Complexity: O(log(x))
 */
public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return reverse(x) == x;
    }

    int reverse(int x) {
        int res = 0;
        while (x > 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
