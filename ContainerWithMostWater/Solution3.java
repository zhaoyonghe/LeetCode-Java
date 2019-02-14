package ContainerWithMostWater;
/**
 * Assume n is height.length.
 * Time Complexity: O(n ^ 2), need to do O(n) multiplications.
 * Space Complexity: O(1)
 * Runtime: 298ms
 * Rank: 38.14%
 */
public class Solution3 {
	public int maxArea(int[] height) {
		// It is actually also a brute force algorithm, but compared with solution2, it needs no extra space.
		int result = 0;
		for (int width = 1; width < height.length; width++) {
			int maxHeight = 0;
			for (int left = 0; left < height.length - width; left++) {
				int temp = Math.min(height[left], height[left + width]);
				if (maxHeight < temp) {
					maxHeight = temp;
				}
			}
			int area = width * maxHeight;
			if (result < area) {
				result = area;
			}
		}
		return result;
	}

}
