package H.HappyNumber_202;

import java.util.HashSet;

/**
 * $$ Time Complexity: O(logn)
 * $$ Space Complexity: O(1)
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
