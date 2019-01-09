package ContainerWithMostWater;
/**
 * Time Complexity: O(height.length ^ 2) with multiplication O(height.length)
 * Space Complexity: O(1)
 * Runtime: 298ms
 * Rank: 38.14%
 */
public class Solution3 {
	public int maxArea(int[] height) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
