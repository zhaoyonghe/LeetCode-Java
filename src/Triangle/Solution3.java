package Triangle;

import java.util.List;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 5ms
 * Rank: 33.81%
 */
public class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int i = n - 2; i >= 0; i--) {
            List<Integer> li = triangle.get(i);
            List<Integer> lip = triangle.get(i + 1);
            for (int j = 0; j <= i; j++) {
                li.set(j, li.get(j) + Math.min(lip.get(j), lip.get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }
}
