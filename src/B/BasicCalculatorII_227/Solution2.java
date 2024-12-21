package B.BasicCalculatorII_227;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume n is s.length().
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

class Solution2 {
    public int calculate(String s) {
        Deque<Character> opst = new ArrayDeque<>();
        Deque<Integer> intst = new ArrayDeque<>();
        s = s.replace(" ", "");

        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int[] ret = getNextInt(s, i);
                intst.push(ret[0]);
                i = ret[1];
                while (!opst.isEmpty() && (opst.peek() == '*' || opst.peek() == '/')) {
                    int b = intst.pop();
                    int a = intst.pop();
                    intst.push(cal(a, b, opst.pop()));
                }
            } else {
                // s.charAt(i) is an op
                opst.push(s.charAt(i));
                i++;
            }
        }

        opst = opst.reversed();
        intst = intst.reversed();

        while (!opst.isEmpty()) {
            intst.push(cal(intst.pop(), intst.pop(), opst.pop()));
        }
        return intst.peek();
    }

    private int cal(int a, int b, char op) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> -1;
        };
    }

    private int[] getNextInt(String s, int i) {
        int[] ret = new int[]{0, i};
        for (; ret[1] < s.length() && Character.isDigit(s.charAt(ret[1])); ret[1]++) {
            ret[0] = ret[0] * 10 + (int) (s.charAt(ret[1]) - '0');
        }
        return ret;
    }

}
