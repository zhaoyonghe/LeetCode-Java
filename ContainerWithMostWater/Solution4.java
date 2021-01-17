package ContainerWithMostWater;

/**
 * Assume n is height.length.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 5ms
 * Rank: 99.43%
 */
public class Solution4 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length;
        int maxArea = 0;
        while (left != right) {
            int nowArea = (right - left) * Math.min(height[left], height[right]);
            if (maxArea < nowArea) {
                maxArea = nowArea;
            }
            // If we want to find a bigger container with relatively shorter width,
            // we need to improve the lower height.
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
