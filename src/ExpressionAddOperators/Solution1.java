package ExpressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the num.length is n.
 * Time Complexity: O(3^n * n)
 * Space Complexity: O(n)
 * Runtime: 8ms
 * Rank: 94.38%
 */

class Solution1 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        char[] s = new char[num.length() * 2];
        char[] nums = num.toCharArray();
        long n = 0;
        for (int i = 0; i < nums.length; i++) {
            n *= 10;
            n += nums[i] - '0';
            s[i] = nums[i];
            helper(nums, i + 1, s, i + 1, true, n, n, target, res);
            if (nums[0] == '0') {
                break;
            }
        }
        return res;
    }

    public void helper(char[] nums, int i, char[] s, int len, boolean adding, long mul, long cur, int target, List<String> res) {
        if (i == nums.length) {
            if (cur == (long) target) {
                res.add(new String(s, 0, len));
            }
            return;
        }

        long n = 0;
        int opIndex = len;
        len++;
        for (int j = i; j < nums.length; j++) {
            n *= 10;
            n += nums[j] - '0';
            s[len] = nums[j];
            len++;
            s[opIndex] = '+';
            helper(nums, j + 1, s, len, true, n, cur + n, target, res);
            s[opIndex] = '-';
            helper(nums, j + 1, s, len, false, n, cur - n, target, res);
            s[opIndex] = '*';
            if (adding) {
                helper(nums, j + 1, s, len, true, mul * n, cur - mul + mul * n, target, res);
            } else {
                helper(nums, j + 1, s, len, false, mul * n, cur + mul - mul * n, target, res);
            }
            if (nums[i] == '0') {
                return;
            }
        }
    }
}