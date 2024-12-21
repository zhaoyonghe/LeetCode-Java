package J.JumpGameIII_1306;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * $$ Assume arr.length is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }

        int n = arr.length;

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            int leftTarget = cur - arr[cur];
            if (leftTarget >= 0) {
                if (arr[leftTarget] == 0) {
                    return true;
                }
                if (!visited[leftTarget]) {
                    visited[leftTarget] = true;
                    q.offer(leftTarget);
                }
            }
            int rightTarget = cur + arr[cur];
            if (rightTarget < arr.length) {
                if (arr[rightTarget] == 0) {
                    return true;
                }
                if (!visited[rightTarget]) {
                    visited[rightTarget] = true;
                    q.offer(rightTarget);
                }
            }
        }
        return false;
    }
}
