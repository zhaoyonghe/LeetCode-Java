package BasicCalculatorI;

import java.util.LinkedList;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 22ms
 * Rank: 77.31%
 */
class Solution3 {
    public int calculate(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();

        LinkedList<Integer> stack = new LinkedList<>();

        int i = 0;
        int num = 0;
        int sign = 1;

        while (i < len) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int temp = 0;
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    temp *= 10;
                    temp += (s.charAt(i) - '0');

                    i += 1;
                }
                num += sign * temp;
            } else if (s.charAt(i) == '+') {
                sign = 1;
                i += 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
                i += 1;
            } else if (s.charAt(i) == '(') {
                stack.push(num);
                stack.push(sign);
                num = 0;
                sign = 1;
                i += 1;
            } else if (s.charAt(i) == ')') {
                num = stack.pop() * num + stack.pop();
                i += 1;
            } else {
                // s.charAt(i) == ' '
                i += 1;
            }
        }

        return num;

    }
}