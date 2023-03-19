package KClosestPointsToOrigin_973;

/**
 * $$ Assume n is points.length.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(logn)
 */
public class Solution1 {
    public int[][] kClosest(int[][] points, int k) {
        partition(points, 0, points.length - 1, k);
        int[][] res = new int[k][2];
        System.arraycopy(points, 0, res, 0, k);
        return res;
    }

    private void partition(int[][] points, int s, int e, int k) {
        int i = s;
        int j = e - 1;
        int dise = dis(points[e]);
        while (i <= j) {
            if (dis(points[i]) <= dise) {
                i++;
                continue;
            }
            swap(points, i, j);
            j--;
        }

        swap(points, i, e);
        if (i - s + 1 < k) {
            partition(points, i + 1, e, k - i + s - 1);
            return;
        }
        if (i - s + 1 > k) {
            partition(points, s, i - 1, k);
            return;
        }
        // i - s + 1 == k
        return;
    }

    private int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] a, int i, int j) {
        int[] tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
