package ContainerWithMostWater;

import java.util.Arrays;
/**
 * Time Complexity: O(height.length ^ 2) with multiplication O(height.length)
 * Space Complexity: O(height.length)
 * Runtime: 390ms
 * Rank: 23.04%
 */
public class Solution2 {
	public int maxArea(int[] height) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
