package M.MaximumCandiesYouCanGetFromBoxes;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Assume status.length is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 4ms
 * Rank: 95.22%
 */
public class Solution1 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int sum = 0;
        int n = status.length;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int b : initialBoxes) {
            queue.offer(b);
        }

        boolean[] keysTable = new boolean[n];
        boolean flag = true;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                int b = queue.poll();
                if (status[b] == 1 || keysTable[b]) {
                    sum += candies[b];
                    for (int key : keys[b]) {
                        keysTable[key] = true;
                        flag = false;
                    }
                    for (int box : containedBoxes[b]) {
                        queue.offer(box);
                        flag = false;
                    }
                } else {
                    queue.offer(b);
                }
            }
            if (flag) {
                return sum;
            } else {
                flag = true;
            }
        }
        return sum;
    }
}
