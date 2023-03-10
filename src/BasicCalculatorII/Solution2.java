package BasicCalculatorII;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Assume n is s.length().
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 30ms
 * Rank: 78.79%
 */

public class Solution2 {
    class Solution {
        public int calculate(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }

            Deque<Integer> nums = new LinkedList<Integer>();
            Deque<Character> ops = new LinkedList<Character>();

            char[] chars = s.toCharArray();

            int len = chars.length;

            int i = 0;

            while (i < len) {
                if (chars[i] == ' ') {
                    i += 1;
                } else if (chars[i] == '+' || chars[i] == '-' || chars[i] == '*' || chars[i] == '/') {
                    ops.offerLast(chars[i]);
                    i += 1;
                } else {
                    int num2 = 0;
                    while (i < len) {
                        if (chars[i] < '0' || chars[i] > '9') {
                            break;
                        }

                        num2 *= 10;
                        num2 += (chars[i] - '0');

                        i += 1;
                    }
                    if (nums.isEmpty() || ops.peekLast() == '+' || ops.peekLast() == '-') {
                        nums.offerLast(num2);
                    } else {
                        if (ops.peekLast() == '*' || ops.peekLast() == '/') {
                            int num1 = nums.pollLast();
                            char op = ops.pollLast();
                            nums.offerLast(doCalculate(num1, num2, op));
                        }
                    }

                }
            }

            int result = nums.pollFirst();

            while (!nums.isEmpty()) {
                result = doCalculate(result, nums.pollFirst(), ops.pollFirst());
            }

            return result;
        }

        public int doCalculate(int num1, int num2, char op) {
            switch (op) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                case '/':
                    return num1 / num2;
                default:
                    return 0;
            }
        }
    }
}
