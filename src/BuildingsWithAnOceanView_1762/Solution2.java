package BuildingsWithAnOceanView_1762;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Assume n is heights.length.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 94.80%
 */

public class Solution2 {
    // Important constraints:
    // 1. heights[i] >= 1 (input is valid)
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        List<Integer> li = new ArrayList<>();
        int rightMax = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] <= rightMax) {
                continue;
            }
            rightMax = heights[i];
            li.add(i);
        }
        int[] res = new int[li.size()];
        ListIterator<Integer> it = li.listIterator(li.size());
        int i = 0;
        while (it.hasPrevious()) {
            res[i] = it.previous();
            i++;
        }
        return res;
    }
}
