package UniquePathsIII_980;

/**
 * $$ Time Complexity: O(m * n)
 * $$ Space Complexity: O(m * n)
 */
public class Solution1 {
    private int result = 0;
    private int shouldVisit = 0;
    private int m = 0;
    private int n = 0;

    public int uniquePathsIII(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[] start = get(grid, 1);
        boolean[][] visited = new boolean[m][n];
        this.shouldVisit = count(grid, 0) + 1;
        dfs(grid, start[0], start[1], visited, 0);

        return this.result;
    }

    private void dfs(int[][] grid, int x, int y, boolean[][] visited, int hasBeenVisited) {
        // grid[x][y] == 1 is covered by visited[x][y]
        if (x < 0 || x >= this.m || y < 0 || y >= this.n || visited[x][y] || grid[x][y] == -1) {
            return;
        }
        if (grid[x][y] == 2) {
            if (this.shouldVisit != hasBeenVisited) {
                return;
            }
            this.result++;
            return;
        }
        visited[x][y] = true;
        dfs(grid, x+1, y, visited, hasBeenVisited+1);
        dfs(grid, x-1, y, visited, hasBeenVisited+1);
        dfs(grid, x, y+1, visited, hasBeenVisited+1);
        dfs(grid, x, y-1, visited, hasBeenVisited+1);
        visited[x][y] = false;
    }

    private int[] get(int[][] grid, int num) {
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == num) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private int count(int[][] grid, int num) {
        int count = 0;
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if (grid[i][j] == num) {
                    count++;
                }
            }
        }
        return count;
    }
}
