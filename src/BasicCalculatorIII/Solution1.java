package BasicCalculatorIII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume s.length() is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 7ms
 * Rank: 71.88%
 */
public class Solution1 {
    public int calculate(String s) {
        Deque<Integer> st = new ArrayDeque<>();
        int i = 0;

        int num = 0;
        char op = '+';

        char[] ss = s.toCharArray();

        while (i < ss.length) {
            if (Character.isDigit(ss[i])) {
                // build the num
                while (i < ss.length && Character.isDigit(ss[i])) {
                    num = num * 10 + (ss[i] - '0');
                    i += 1;
                }
            } else if (ss[i] == '(') {
                i += 1;
                int j = i;
                int count = 1;
                while (count != 0) {
                    if (ss[i] == '(') {
                        count += 1;
                    }
                    if (ss[i] == ')') {
                        count -= 1;
                    }
                    i += 1;
                }
                num = calculate(s.substring(j, i));
            } else if (ss[i] == ' ') {
                i += 1;
            } else {
                // ss[i] is op
                switch (op) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                }
                op = ss[i];
                num = 0;
                i += 1;
            }

            if (i >= ss.length) {
                switch (op) {
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop() * num);
                        break;
                    case '/':
                        st.push(st.pop() / num);
                        break;
                }
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }
        return sum;
    }
}
