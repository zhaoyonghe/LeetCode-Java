package R.ReachingPoints_780;

/**
 * Time Complexity: O(log(min(tx,ty))) https://sites.math.rutgers.edu/~ajl213/CLRS/Ch31.pdf, 31.2-5
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    // Important constraints:
    // 1. 1 <= sx, sy, tx, ty <= 10 ^ 9
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx <= tx && sy <= ty) {
            if (sx == tx && sy == ty) {
                return true;
            }
            if (tx < ty) {
                if (tx != sx) {
                    ty %= tx;
                    continue;
                }
                // tx == sx && sy < ty
                // return sy + a * tx == ty ?
                return (ty - sy) % tx == 0;
            } else if (tx > ty) {
                if (ty != sy) {
                    tx %= ty;
                    continue;
                }
                // ty == sy && sx < tx
                // return sx + a * ty == tx ?
                return (tx - sx) % ty == 0;
            } else {
                // tx == ty
                return false;
            }
        }
        return false;
    }
}