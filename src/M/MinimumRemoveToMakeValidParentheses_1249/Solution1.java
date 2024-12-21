package M.MinimumRemoveToMakeValidParentheses_1249;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume n is prices.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 92.74%
 */

public class Solution1 {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(i);
                continue;
            }
            if (c == ')') {
                if (stack.isEmpty() || chars[stack.peek()] == ')') {
                    stack.push(i);
                    continue;
                }
                stack.pop();
            }
        }

        for (Integer index : stack) {
            chars[index] = '.';
        }

        for (char c : chars) {
            if (c == '.') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}