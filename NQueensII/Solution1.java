package NQueensII;
/**
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 58.96%
 */
public class Solution1 {
	class Solution {
		int count = 0;

		public int totalNQueens(int n) {
			boolean[] avacol = new boolean[n];
			solve(new int[n], avacol, 0, n);
			return count;
		}

		public void solve(int[] pos, boolean[] avacol, int i, int n) {
			if (i == n) {
				count += 1;
				return;
			}

			for (int col = 0; col < n; col++) {
				if (!avacol[col]) {
					boolean flag = false;
					for (int k = 0; k < i; k++) {
						if (Math.abs(k - i) == Math.abs(pos[k] - col)) {
							flag = true;
							break;
						}
					}
					if (flag) {
						continue;
					}
					avacol[col] = true;
					pos[i] = col;
					solve(pos, avacol, i + 1, n);
					avacol[col] = false;
				}
			}
		}
	}
}
