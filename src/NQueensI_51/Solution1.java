package NQueensI_51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * $$ Time Complexity: O(n!)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        helper(new int[n], 0, n, res);
        return res;
    }

    private void helper(int[] posByRank, int iRank, int n, List<List<String>> res) {
        if (iRank == n) {
            res.add(drawBoard(posByRank));
            return;
        }

        for (int iFile = 0; iFile < n; iFile++) {
            // put queen on [iRank, iFile]
            posByRank[iRank] = iFile;

            boolean attacked = false;
            for (int j = 0; j < iRank; j++) {
                // another queen is on [j, posByRank[j]]
                if (posByRank[j] == iFile || Math.abs(j - iRank) == Math.abs(posByRank[j] - iFile)) {
                    attacked = true;
                    break;
                }
            }
            if (!attacked) {
                helper(posByRank, iRank + 1, n, res);
            }
        }
    }

    private List<String> drawBoard(int[] posByRank) {
        List<String> res = new ArrayList<>();
        char[] rank = new char[posByRank.length];
        for (int file : posByRank) {
            Arrays.fill(rank, '.');
            rank[file] = 'Q';
            res.add(new String(rank));
        }
        return res;
    }
}
