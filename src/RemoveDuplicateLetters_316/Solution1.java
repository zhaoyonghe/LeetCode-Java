package RemoveDuplicateLetters_316;

import java.util.*;

/**
 * Assume n is the length of num.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 91.41%
 */

public class Solution1 {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[128];
        for (int i = 0; i < s.length(); i++) {
            last[(int) s.charAt(i)] = i;
        }

        boolean[] map = new boolean[128];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            if (map[c]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && last[stack.peek()] > i) {
                map[stack.pop()] = false;
            }
            stack.push(c);
            map[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> dit = stack.descendingIterator();
        while (dit.hasNext()) {
            sb.append((char) ((int) dit.next()));
        }
        return sb.toString();
    }
}
