package R.RotateArray;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 89.59%
 */
public class Solution1 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if (k == 0) {
            return;
        }
        if (n == 1) {
            return;
        }
        int a = k;
        int b = n;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        assert a == b;
        int m = a;
        for (int i = 0; i < m; i++) {
            int target = (i + k) % n;
            int dump = nums[i];
            for (int j = 0; j < n / m; j++) {
                int temp = nums[target];
                nums[target] = dump;
                dump = temp;
                target = (target + k) % n;
            }
        }
    }
}
