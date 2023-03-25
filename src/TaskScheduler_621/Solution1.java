package TaskScheduler_621;

import java.util.*;
/**
 * $$ Assume tasks.length is k.
 * $$ Time Complexity: O(n + klogk)
 * $$ Space Complexity: O(k)
 */
public class Solution1 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[128];
        for (char c: tasks) {
            map[c]++;
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->Integer.compare(map[b], map[a]));
        for (int i = 0; i < 128; i++) {
            if (map[i] > 0) {
                pq.offer((char)i);
            }
        }

        PriorityQueue<int[]> timePQ = new PriorityQueue<>((a,b)->Integer.compare(a[1], b[1]));

        int time = 0;
        while (!pq.isEmpty() || !timePQ.isEmpty()) {
            time++;
            if (!timePQ.isEmpty() && time == timePQ.peek()[1]) {
                pq.offer((char)timePQ.poll()[0]);
            }
            if (!pq.isEmpty()) {
                char task = pq.poll();
                map[task]--;
                if (map[task] > 0) {
                    timePQ.offer(new int[]{task, time + n + 1});
                }
            }
        }
        return time;
    }
}