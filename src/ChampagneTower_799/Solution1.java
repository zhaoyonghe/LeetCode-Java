package ChampagneTower_799;
/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 92.31%
 */

public class Solution1 {
// Important constraints:
// 1. 0 <= query_glass <= query_row < 100 (input is valid and bounded).
public double champagneTower(int poured, int query_row, int query_glass) {
    double[][] tower = new double[query_row + 1][100];
    tower[0][0] = (double)poured;
    for (int i = 0; i <= query_row; i++) {
        for (int j = 0; j <= i; j++) {
            if (tower[i][j] <= 1.0) {
                continue;
            }
            double down = (tower[i][j] - 1.0) / 2.0;
            tower[i][j] = 1.0;
            if (i < query_row) {
                tower[i+1][j] += down;
                tower[i+1][j+1] += down;
            }
        }
    }
    return tower[query_row][query_glass];
}
}