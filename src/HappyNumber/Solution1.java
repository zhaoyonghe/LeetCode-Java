package HappyNumber;

import java.util.HashSet;

/**
 * Assume m is the length of the chain until the cycle appears.
 * Time Complexity: O(m * logn)
 * Space Complexity: O(m)
 * Runtime: 4ms
 * Rank: 76.09%
 */
public class Solution1 {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        while (true) {
            while (n != 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            n = sum;
            sum = 0;
        }
    }
}
