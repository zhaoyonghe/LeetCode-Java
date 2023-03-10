package KClosestPointsToOrigin_973;

import java.util.Random;
/**
 * Assume n is points.length.
 * Time Complexity: O(n)
 * Space Complexity: O(logn)
 * Runtime: 7ms
 * Rank: 88.32%
 */
public class Solution2 {
    Random rand = new Random();

    public int[][] kClosest(int[][] points, int k) {
        // Important constraints:
        // 1 <= k <= points.length <= 10^4 (answer always exists)
        // -10^4 < xi, yi < 10^4 (distance calculate will not overflow)
        partition(points,0,points.length-1,k);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private void partition(int[][] points, int s, int e, int k) {
        if (s < e) {
            swap(points, e, rand.nextInt(e-s+1)+s);
        }
        int[] p = points[e];
        int i = s;
        int j = e - 1;
        int dise = dis(points[e]);
        while (i <= j) {
            if (dis(points[i]) <= dise) {
                i++;
            } else {
                swap(points, i, j);
                j--;
            }
        }

        swap(points, i, e);
        if (i-s+1<k) {
            partition(points, i+1, e, k-i+s-1);
            return;
        }
        if (i-s+1>k) {
            partition(points, s, i-1, k);
            return;
        }
        return;
    }

    private int dis(int[] point) {
        return point[0]*point[0]+point[1]*point[1];
    }

    private void swap(int[][] a, int i, int j) {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
