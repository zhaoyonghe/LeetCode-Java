package NumberOfIslands;
/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 * Runtime: 3ms
 * Rank: 95.66%
 */
class Solution3 {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		int m = grid.length;
		int n = grid[0].length;

		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j, m, n);
					count += 1;
				}
			}
		}

		return count;

	}

	public void dfs(char[][] grid, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i == m || j == n || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		dfs(grid, i - 1, j, m, n);
		dfs(grid, i, j - 1, m, n);
		dfs(grid, i + 1, j, m, n);
		dfs(grid, i, j + 1, m, n);
	}
}