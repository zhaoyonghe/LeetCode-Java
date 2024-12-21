package R.ReverseInteger_7;

/**
 * $$ Time Complexity: O(log(x))
 * $$ Space Complexity: O(log(x))
 */
public class Solution1 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE || x == 0) {
            return 0;
        }
        int[] nums = new int[10];
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int i = 0;
        for (i = 0; i < 10 && x != 0; i++) {
            nums[i] = x % 10;
            x /= 10;
        }
        int res = 0;
        for (int j = 0; j < i; j++) {
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res *= 10;
            res += nums[j];
        }
        if (res < 0) {
            return 0;
        }
        return neg ? -res : res;
    }
}
