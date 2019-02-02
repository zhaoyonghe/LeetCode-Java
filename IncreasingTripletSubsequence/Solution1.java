package IncreasingTripletSubsequence;
/**
 * Assume the length of nums is n;
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 93.37%
 */
public class Solution1 {
	public boolean increasingTriplet(int[] nums) {
		int num1 = Integer.MAX_VALUE;
		int num2 = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num <= num1) {
				num1 = num;
			} else if (num > num1 && num <= num2) {
				num2 = num;
			} else {
				// num > num2
				return true;
			}
		}
		return false;
	}
}
