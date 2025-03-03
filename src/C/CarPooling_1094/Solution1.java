package C.CarPooling_1094;

import java.util.PriorityQueue;

/**
 * $$ Assume trips.length is n.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        for (int[] trip : trips) {
            pq.offer(new int[]{trip[1], trip[0]});
            pq.offer(new int[]{trip[2], -trip[0]});
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            cnt += next[1];
            if (cnt > capacity) {
                return false;
            }
        }

        return true;
    }
}