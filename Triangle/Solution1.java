package Triangle;

import java.util.List;

/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 11ms
 * Rank: 6.53%
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        for (int i = 1; i < n; i++) {
            triangle.get(i).set(0, triangle.get(i).get(0) + triangle.get(i - 1).get(0));
            triangle.get(i).set(i, triangle.get(i).get(i) + triangle.get(i - 1).get(i - 1));
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(j,
                        triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
            }
        }

        return triangle.get(n - 1).stream().min((i, j) -> (i - j)).get();
    }
}
