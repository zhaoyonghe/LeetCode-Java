package SingleNumberIII;
/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 77.94%
 */
public class Solution1 {
	public int[] singleNumber(int[] nums) {
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
