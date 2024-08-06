package MinimumNumberOfTapsToOpenToWaterAGarden_1326;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 31.13%
 */

public class Solution1 {
    public int minTaps(int n, int[] ranges) {
        int[] prev = null;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            int[] cur = new int[]{Math.max(0, i - ranges[i]), Math.min(n, i + ranges[i])};
            if (cur[0] == 0 && (prev == null || prev[1] < cur[1])) {
                prev = cur;
                continue;
            }
            // cur[0] > 0
            list.add(cur);
        }
        if (prev == null) {
            // Cannot cover 0.
            return -1;
        }
        int res = 1;
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        int[] cand = prev;
        for (int[] cur : list) {
            if (prev[1] < cur[0]) {
                // cand is critical.
                if (cur[0] <= cand[1]) {
                    prev = cand;
                    if (prev[1] < cur[1]) {
                        cand = cur;
                    }
                    res++;
                    continue;
                }
                // cand[1] < cur[0]
                // A gap is found.
                return -1;
            }
            // cur[0] <= prev[1]
            // cur is another candidate.
            if (cur[1] <= cand[1]) {
                // cur is not better than cand.
                continue;
            }
            // cur is better than cand.
            cand = cur;
        }
        if (prev[1] < cand[1]) {
            return res + 1;
        }
        return res;
    }
}