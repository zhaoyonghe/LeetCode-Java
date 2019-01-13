package ClimbingStairs;
/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 3ms
 * Rank: 79.10%
 */
public class Solution1 {
	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] result = new int[n];
		result[0] = 1;
		result[1] = 2;
		for (int i = 2; i < n; i++) {
			result[i] = result[i - 1] + result[i - 2];
		}
		return result[n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
