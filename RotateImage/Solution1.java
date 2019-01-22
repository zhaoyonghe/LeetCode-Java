package RotateImage;
/**
 * Assume n is the length of matrix.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 84.50%
 */
public class Solution1 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int assign = 0;
		int hold = 0;
		for (int x = 0; x < Math.ceil((double) n / 2); x++) {
			for (int y = 0; y < n / 2; y++) {
				int targetx = 0;
				int targety = 0;
				// rotate 1
				assign = matrix[x][y];
				targetx = y;
				targety = n - x - 1;
				hold = matrix[targetx][targety];
				matrix[targetx][targety] = assign;
				// rotate 2
				assign = hold;
				targetx = n - x - 1;
				targety = n - y - 1;
				hold = matrix[targetx][targety];
				matrix[targetx][targety] = assign;
				// rotate 3
				assign = hold;
				targetx = n - y - 1;
				targety = x;
				hold = matrix[targetx][targety];
				matrix[targetx][targety] = assign;
				// rotate 4
				assign = hold;
				targetx = x;
				targety = y;
				hold = matrix[targetx][targety];
				matrix[targetx][targety] = assign;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[9][9];
		System.out.println(Math.ceil(3 / 2));
		System.out.println(Math.ceil(4 / 2));
	}

}
