package ContainerWithMostWater_11;

import java.lang.Math;

/**
 * Assume n is height.length.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(1)
 * Runtime: 3ms
 * Rank: 83.78%
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = Math.max(res, Math.min(height[i],height[j])*(j-i));
            if (height[i] < height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return res;
    }
}
