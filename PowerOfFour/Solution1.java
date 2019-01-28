package PowerOfFour;
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 100.00%
 */
public class Solution1 {
	class Solution {
		public boolean isPowerOfFour(int num) {
			if (num <= 0) {
				return false;
			}
			if (num == 1) {
				return true;
			}
			return ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
		}
	}
}
