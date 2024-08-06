package EvaluateReversePolishNotation_150;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume tokens.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.length() == 1 && !Character.isDigit(token.charAt(0))) {
                int b = st.pop();
                int a = st.pop();
                st.push(cal(a, b, token.charAt(0)));
                continue;
            }
            st.push(Integer.parseInt(token));
        }
        return st.peek();
    }

    private int cal(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        }
        if (op == '-') {
            return a - b;
        }
        if (op == '*') {
            return a * b;
        }
        return a / b;
    }
}