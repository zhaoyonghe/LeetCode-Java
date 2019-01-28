package PowerOfThree;
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 14ms
 * Rank: 99.90%
 */
public class Solution1 {
	public boolean isPowerOfThree(int n) {
		return n > 0 && 1162261467 % n == 0;
	}
}
