package ContainerWithMostWater;

import java.lang.Math;
/**
 * Assume n is height.length.
 * Time Complexity: O(n ^ 2), need to do O(n ^ 2) multiplications
 * Space Complexity: O(1)
 * Runtime: 390ms
 * Rank: 23.04%
 */
public class Solution1 {
	public int maxArea(int[] height) {
		// brute force
		int left = 0;
		int result = 0;
		for (; left < height.length - 1; left++) {
			for (int right = left + 1; right < height.length; right++) {
				int temp = Math.min(height[left], height[right]) * (right - left);
				if (temp > result) {
					result = temp;
				}
			}
		}
		return result;
	}
}
