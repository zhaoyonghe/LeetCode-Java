package AsteroidCollision_735;

import java.util.*;
/**
 * Assume n is asteroids.length().
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 5ms
 * Rank: 90.39%
 */
public class Solution1 {
public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> st = new ArrayDeque<>();
    for (int a : asteroids) {
        if (a > 0) {
            st.push(a);
            continue;
        }

        while (true) {
            if (st.isEmpty() || st.peek() < 0) {
                st.push(a);
                break;
            }
            // asteroids[i] != 0, so st.peek() > 0
            if (st.peek() < -a) {
                st.pop();
                continue;
            }
            if (st.peek() == -a) {
                st.pop();
            }
            // st.peek() > 0 && st.peek() > -a
            break;
        }
    }
    int[] res = new int[st.size()];
    Iterator<Integer> it = st.descendingIterator();
    int i = 0;
    while (it.hasNext()) {
        res[i] = it.next();
        i++;
    }
    return res;
}
}