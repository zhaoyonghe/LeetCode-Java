package HappyNumber;

/**
 * Assume m is the length of the chain until the cycle appears.
 * Time Complexity: O(m * logn)
 * Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 76.09%
 */
public class Solution2 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = helper(slow);
            fast = helper(helper(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int helper(int n) {
        int sum = 0, tmp;
        while (n != 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }
}
