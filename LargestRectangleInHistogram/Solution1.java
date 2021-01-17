package LargestRectangleInHistogram;

/**
 * Assume heights.length is n.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 262ms
 * Rank: 43.57%
 */
public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j--;
            }
            while (k < heights.length && heights[k] >= heights[i]) {
                k++;
            }
            int s = heights[i] * (k - j - 1);
            max = s > max ? s : max;
        }

        return max;
    }
}
