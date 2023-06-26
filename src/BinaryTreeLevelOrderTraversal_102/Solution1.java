package BinaryTreeLevelOrderTraversal_102;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(root.left, level + 1, res);
        helper(root.right, level + 1, res);
    }

}
