package RemoveKDigits_402;

import java.util.*;

/**
 * Assume n is the length of num.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 75.31%
 */

public class Solution1 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        //
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> it = stack.descendingIterator();
        boolean leadingZero = true;
        while (it.hasNext()) {
            char next = it.next();
            if (leadingZero && next == '0') {
                continue;
            }
            leadingZero = false;
            sb.append(next);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
