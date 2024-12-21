package C.ContainerWithMostWater_11;

/**
 * $$ Assume n is height.length.
 * $$ Time Complexity: O(n)
 * $$ Auxiliary Space Complexity: O(1)
 */
public class Solution1 {
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > result) {
                result = area;
            }
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}
