package CarFleet_853;

import java.util.*;
/**
 * $$ Assume n is position.length.
 * $$ Time Complexity: O(nlogn)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] ps = new int[n][2];
        for (int i = 0; i < n; i++) {
            ps[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(ps, (a,b)->Integer.compare(b[0], a[0]));
        int fleet = 1;
        double prevFleetTimeToTarget = (double)(target - ps[0][0])/(double)(ps[0][1]);
        for (int i = 1; i < n; i++) {
            double thisCarTimeToTarget = (double)(target - ps[i][0])/(double)(ps[i][1]);
            if (prevFleetTimeToTarget >= thisCarTimeToTarget) {
                continue;
            }
            prevFleetTimeToTarget = thisCarTimeToTarget;
            fleet++;
        }
        return fleet;
    }
}