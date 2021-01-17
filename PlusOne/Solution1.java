package PlusOne;

import java.util.Arrays;

/**
 * Time Complexity: O(digits.length)
 * Space Complexity: O(digits.length)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int[] plusOne(int[] digits) {
        int[] newdigits = new int[digits.length + 1];
        int carry = 0;
        boolean lastdigit = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum;
            if (lastdigit) {
                sum = digits[i] + 1 + carry;
                lastdigit = false;
            } else {
                sum = digits[i] + carry;
            }
            carry = sum / 10;
            newdigits[i + 1] = sum % 10;
        }
        if (carry == 1) {
            newdigits[0] = 1;
        } else {
            newdigits = Arrays.copyOfRange(newdigits, 1, newdigits.length);
        }
        return newdigits;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = new int[3];
        System.out.println(a[2]);
    }

}
