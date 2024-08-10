package BasicCalculatorII_227;

import java.util.LinkedList;

/**
 * $$ Assume n is s.length().
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */


class Solution1 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int len = s.length();

        LinkedList<Integer> stack = new LinkedList<>();

        int num = 0;
        char sign = '+';

        int i = 0;

        while (i <= len) {
            if (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    num *= 10;
                    num += (s.charAt(i) - '0');

                    i += 1;
                }
                continue;
            }

            if (i == len || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                // sign is the operator just before s.charAt(i)
                // num is the number just before s.charAt(i)
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                sign = (i == len ? '+' : s.charAt(i));
                num = 0;
            }

            i += 1;
        }

        stack.push(num);

        int result = 0;
        for (int j : stack) {
            result += j;
        }

        return result;
    }
}
