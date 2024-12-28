package R.RemoveDuplicateLetters_316;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * $$ Assume n is the length of s.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public String removeDuplicateLetters(String s) {
        int len = s.length();

        char[] cs = s.toCharArray();
        int[] lastOccurrence = new int[128];
        for (int i = 0; i < len; i++) {
            lastOccurrence[cs[i]] = i;
        }
        boolean[] inStack = new boolean[128];

        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            if (inStack[cs[i]]) {
                continue;
            }
            while (!st.isEmpty() && cs[i] <= st.peek() && i < lastOccurrence[st.peek()]) {
                inStack[st.pop()] = false;
            }
            st.push(cs[i]);
            inStack[cs[i]] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
