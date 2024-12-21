package U.UniqueBinarySearchTreesII_95;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(4 ^ n / n ^ (1 / 2))
 * Space Complexity: O(4 ^ n / n ^ (1 / 2))
 * Runtime: 1ms
 * Rank: 92.02%
 */

class Solution1 {
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    private List<TreeNode> helper(int s, int e) {
        List<TreeNode> res = new ArrayList<>();
        if (s > e) {
            res.add(null);
            return res;
        }

        for (int mid = s; mid <= e; mid++) {
            List<TreeNode> lefts = helper(s, mid - 1);
            List<TreeNode> rights = helper(mid + 1, e);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    res.add(new TreeNode(mid, left, right));
                }
            }
        }
        return res;
    }
}