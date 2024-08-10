package BasicCalculatorI_224;

import java.util.*;

/**
 * $$ Assume n is s.length().
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {

    public int calculate(String s) {
        Deque<Character> opst = new ArrayDeque<>();
        Deque<Integer> intst = new ArrayDeque<>();
        s = s.replace(" ", "");

        int i = s.length() - 1;
        while (i >= 0) {
            Token token = whatIsThis(s, i);
            if (token == Token.INT) {
                int[] ret = getNextInt(s, i);
                intst.push(ret[0]);
                i = ret[1];
            } else if (token == Token.PLUS || token == Token.RIGHT) {
                opst.push(s.charAt(i));
            } else if (token == Token.MINUS) {
                if (i == 0 || whatIsThis(s, i-1) == Token.LEFT) {
                    intst.push(0);
                }
                opst.push('-');
            } else {
                while (opst.peek() != ')') {
                    intst.push(cal(intst.pop(), intst.pop(), opst.pop()));
                }
                opst.pop();
            }
            i--;
        }

        while (!opst.isEmpty()) {
            intst.push(cal(intst.pop(), intst.pop(), opst.pop()));
        }
        return intst.peek();
    }

    private int cal(int a, int b, char op) {
        return op == '+' ? a+b:a-b;
    }

    private enum Token {
        INT, LEFT, RIGHT, PLUS, MINUS
    }

    private int[] getNextInt(String s, int i) {
        int[] ret = new int[]{0,i};
        while (ret[1] > 0 && Character.isDigit(s.charAt(ret[1]-1))) {
            ret[1]--;
        }
        for (int j = ret[1]; j <= i; j++) {
            ret[0] = ret[0] * 10 + (int)(s.charAt(j)-'0');
        }
        return ret;
    }

    private Token whatIsThis(String s, int i) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            return Token.INT;
        }
        if (c == '+') {
            return Token.PLUS;
        }
        if (c == '-') {
            return Token.MINUS;
        }
        if (c == '(') {
            return Token.LEFT;
        }
        return Token.RIGHT;
    }
}
