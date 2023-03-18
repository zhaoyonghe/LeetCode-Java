package AsteroidCollision_735;

import java.util.*;

/**
 * $$ Assume n is asteroids.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int ast : asteroids) {
            if (ast > 0) {
                st.push(ast);
                continue;
            }
            // ast < 0
            boolean exist = true;
            while (!st.isEmpty() && st.peek() > 0) {
                if (-ast < st.peek()) {
                    exist = false;
                    break;
                } else if (-ast > st.peek()) {
                    st.pop();
                    continue;
                } else {
                    st.pop();
                    exist = false;
                    break;
                }
            }
            if (exist) {
                st.push(ast);
            }
        }
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}