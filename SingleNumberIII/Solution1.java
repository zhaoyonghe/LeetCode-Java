package SingleNumberIII;
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 77.94%
 */
public class Solution1 {
	public int[] singleNumber(int[] nums) {
		// Assume the single numbers are a and b,
		// so doing xor operations for each number in nums
		// is equivalent to a ^ b.
		// Since a and b are different, so a ^ b not equals to 0.
		// It means that a ^ b at least has one bit that is 1
		// and we can use the bit that is 1 to divide the nums into two part:
		// one part contains a and the other contains b.
		// Now this problem is converted to two "Single Number I" problems.
		int div = 0;
		for (int i = 0; i < nums.length; i++) {
			div ^= nums[i];
		}
		for (int i = 0; i < 32; i++) {
			if (((1 << i) & div) != 0) {
				div = (1 << i);
				break;
			}
		}
		int a = 0;
		int b = 0;
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & div) != 0) {
				a ^= nums[i];
			} else {
				b ^= nums[i];
			}
		}
		return new int[] { a, b };
	}
}
