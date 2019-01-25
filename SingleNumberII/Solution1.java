package SingleNumberII;
/**
 * Assume n is the length of integer array nums.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 96.77%
 */
public class Solution1 {
	public int singleNumber(int[] nums) {
		int x2 = 0;
		int x1 = 0;
		int mask = 0;
		for (int num : nums) {
			x2 = x2 ^ (x1 & num);
			x1 = x1 ^ num;
			mask = ~(x2 & x1);
			x2 = x2 & mask;
			x1 = x1 & mask;
		}
		return x1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
