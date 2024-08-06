package FindLeavesOfBinaryTree_366;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the number of nodes in tree root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        // The number of nodes in the tree is in the range [1, 100] (root != null).
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private int helper(TreeNode node, List<List<Integer>> res) {
        if (node.left == null && node.right == null) {
            if (res.size() == 0) {
                res.add(new ArrayList<>());
            }
            res.get(0).add(node.val);
            return 1;
        }
        int le = 0, ri = 0;
        if (node.left != null) {
            le = helper(node.left, res);
        }
        if (node.right != null) {
            ri = helper(node.right, res);
        }
        int i = Math.max(le, ri);
        if (i == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(i).add(node.val);
        return i + 1;
    }
}