package NumberOfIslands;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 6ms
 * Rank: 32.63%
 */

public class Solution1 {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;
		int[] union = new int[m * n];
		for (int i = 0; i < union.length; i++) {
			union[i] = -1;
		}

		int index = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				index += 1; // index = i * n + j;
				if (grid[i][j] == '1') {
					if (j - 1 >= 0 && grid[i][j - 1] == '1') {
						// join the left
						merge(union, index - 1, index);
					}
					if (i - 1 >= 0 && grid[i - 1][j] == '1') {
						// join the up
						merge(union, index - n, index);
					}
				} else {
					union[index] = -2;
				}
			}
		}

		int count = 0;
		for (int num : union) {
			if (num == -1) {
				count += 1;
			}
		}

		return count;
	}

	public int findRoot(int[] union, int i) {
		while (union[i] != -1) {
			i = union[i];
		}
		return i;
	}

	public void merge(int[] union, int i, int j) {
		int ri = findRoot(union, i);
		int rj = findRoot(union, j);
		if (ri != rj) {
			union[rj] = ri;
		}
	}
}
