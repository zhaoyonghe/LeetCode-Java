package FindUniqueBinaryString_1980;

/**
 * $$ Assume nums.length is n.
 * $$ Time Complexity: O(n ^ 2)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        boolean[] set = new boolean[n + 1];
        for (String num : nums) {
            int a = str2Num(num);
            if (a <= n) {
                set[a] = true;
            }
        }
        for (int i = 0; i <= n; i++) {
            if (set[i]) {
                continue;
            }
            return num2Str(i, n);
        }
        return "";
    }

    private String num2Str(int num, int n) {
        char[] str = new char[n];
        for (int i = 0; i < n; i++) {
            str[n - i - 1] = (((1 << i) | num) == num) ? '1' : '0';
        }
        return new String(str);
    }

    private int str2Num(String str) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                num = num | (1 << (str.length() - i - 1));
            }
        }
        return num;
    }
}