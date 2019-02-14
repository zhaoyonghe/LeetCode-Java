package ContainerWithMostWater;

import java.util.Arrays;
/**
 * Assume n is height.length.
 * Time Complexity: O(n ^ 2), need to do O(n) multiplications.
 * Space Complexity: O(n)
 * Runtime: 390ms
 * Rank: 23.04%
 */
public class Solution2 {
	public int maxArea(int[] height) {
		// candidate[i](1 <= i <= height.length) indicates the max height of container with width i.
		// Finally we need to find the max candidate[i] * i.
		// It is actually also a brute force algorithm, but needs to do fewer times of multiplication than solution1.
		int[] candidate = new int[height.length];
		Arrays.fill(candidate, 0);
		for (int left = 0; left < height.length - 1; left++) {
			for (int right = left + 1; right < height.length; right++) {
				int width = right - left;
				int minHeight = Math.min(height[left], height[right]);
				if(candidate[width] < minHeight) {
					candidate[width] = minHeight;
				}
			}
		}
		int result = 0;
		for(int i = 1; i < candidate.length; i++) {
			int area = i * candidate[i];
			if(result < area) {
				result = area;
			}
		}
		return result;
	}

}
