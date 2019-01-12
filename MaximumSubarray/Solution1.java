package MaximumSubarray;
/**
 * Time Complexity: O(nums.length)
 * Space Complexity: O(1)
 * Runtime: 10ms
 * Rank: 88.99%
 */
public class Solution1 {
	public int maxSubArray(int[] nums) {
		int end = 0;
		int result = Integer.MIN_VALUE;
		int sum = 0;
		while (end < nums.length) {
			sum += nums[end];
			if (sum > result) {
				result = sum;
			}
			if (sum < 0) {
				end += 1;
				sum = 0;
			} else {
				end += 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
