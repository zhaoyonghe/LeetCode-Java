package MinimumKnightMoves_1197;

import java.util.*;

/**
 * Time Complexity: O(x + y)
 * Space Complexity: O(x + y)
 * Runtime: 534ms
 * Rank: 42.98%
 */

public class Solution1 {
    private int[][] diffs = {
            {1,2},
            {2,1},
            {-1,2},
            {-2,1},
            {-1,-2},
            {-2,-1},
            {1,-2},
            {2,-1},
    };
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }

        x = Math.abs(x);
        y = Math.abs(y);

        Set<Long> visited = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited.add(key(0,0));
        int count = 1;

        while (q.size() > 0) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] cur = q.poll();
                for (int[] diff: diffs) {
                    int[] next = new int[]{cur[0]+diff[0],cur[1]+diff[1]};
                    if (next[0] < -2 || next[1] < -2 || next[0] > x+2 || next[1] > y+2) {
                        continue;
                    }
                    //System.out.printf("  %X,%d,%d\n",key(next),next[0],next[1]);
                    if (key(next) == key(x, y)) {
                        return count;
                    }
                    if (visited.contains(key(next))) {
                        continue;
                    }
                    visited.add(key(next));
                    q.offer(next);
                }
            }
            count++;
        }

        return count;
    }

    private long key(int[] p) {
        return key(p[0],p[1]);
    }

    private long key(int x, int y) {
        long k = (long)y;
        long a = (long)x;
        // Clear the upper 32 bits.
        k = k & 0xffffffffl;
        k = k | (a << 32);
        return k;
    }
}