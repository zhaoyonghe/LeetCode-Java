package ContainerWithMostWater;

import java.lang.Math;
/**
 * Time Complexity: O(height.length ^ 2) with multiplication O(height.length ^ 2)
 * Space Complexity: O(1)
 * Runtime: 390ms
 * Rank: 23.04%
 */
public class Solution1 {
	public int maxArea(int[] height) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
