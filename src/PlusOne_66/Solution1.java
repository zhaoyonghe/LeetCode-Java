package PlusOne_66;

/**
 * $$ Time Complexity: O(digits.length)
 * $$ Space Complexity: O(digits.length)
 */
public class Solution1 {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >=0 && carry > 0; i--) {
            int digit = digits[i];
            digits[i] = (digit + carry) % 10;
            carry = (digit + carry) / 10;
        }
        if (carry != 0) {
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
