package RotateImage;
/**
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 84.50%
 */
public class Solution2 {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for(int x = 0; x < (n + 1) / 2; x++) {
			for(int y = 0; y < n / 2; y++) {
				int temp1 = matrix[x][y];
				int temp2 = matrix[y][n - x - 1];
				int temp3 = matrix[n - x - 1][n - y - 1];
				int temp4 = matrix[n - y - 1][x];
				matrix[x][y] = temp4;
				matrix[y][n - x - 1] = temp1;
				matrix[n - x - 1][n - y - 1] = temp2;
				matrix[n - y - 1][x] = temp3;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
