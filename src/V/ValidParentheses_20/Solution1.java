package V.ValidParentheses_20;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Time Complexity: O(s.length())
 * $$ Space Complexity: O(s.length())
 */
public class Solution1 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if ((c == ')' && stack.peek() == '(') ||
                    (c == ']' && stack.peek() == '[') ||
                    (c == '}' && stack.peek() == '{')) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
