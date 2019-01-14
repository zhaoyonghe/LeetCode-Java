package ContainerWithMostWater;
/**
 * Time Complexity: O(height.length)
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
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
