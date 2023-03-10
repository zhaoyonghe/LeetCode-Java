package KClosestPointsToOrigin_973;

import java.util.PriorityQueue;
/**
 * Assume n is points.length.
 * Time Complexity: O(n * logk)
 * Space Complexity: O(n)
 * Runtime: 28ms
 * Rank: 54.04%
 */
public class Solution1 {
    public int[][] kClosest(int[][] points, int k) {
        // Important constraints:
        // 1 <= k <= points.length <= 10^4 (answer always exists)
        // -10^4 < xi, yi < 10^4 (distance calculate will not overflow)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
            return b[0]*b[0]+b[1]*b[1]-a[0]*a[0]-a[1]*a[1];
        });
        int[][] res = new int[k][2];
        for (int[] p: points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}