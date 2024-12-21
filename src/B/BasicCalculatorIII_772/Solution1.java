package B.BasicCalculatorIII_772;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume s.length() is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int calculate(String s) {
        Deque<Character> opst = new ArrayDeque<>();
        Deque<Integer> intst = new ArrayDeque<>();
        s = s.replace(" ", "");

        Deque<Character> tmpOpst = new ArrayDeque<>();
        Deque<Integer> tmpIntst = new ArrayDeque<>();

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
            } else if (s.charAt(i) == ')') {
                tmpIntst.push(intst.pop());
                while (opst.peek() != '(') {
                    tmpIntst.push(intst.pop());
                    tmpOpst.push(opst.pop());
                }
                opst.pop(); // pop out the (
                while (!tmpOpst.isEmpty()) {
                    tmpIntst.push(cal(tmpIntst.pop(), tmpIntst.pop(), tmpOpst.pop()));
                }
                intst.push(tmpIntst.pop());
                while (!opst.isEmpty() && (opst.peek() == '*' || opst.peek() == '/')) {
                    int b = intst.pop();
                    int a = intst.pop();
                    intst.push(cal(a, b, opst.pop()));
                }
                i++;
            } else {
                // s.charAt(i) is an op or (
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
