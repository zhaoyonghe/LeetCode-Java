package B.BinaryTreeZigzagLevelOrderTraversal_103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * $$ Assume n is the number of nodes in tree root.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        for (int i = 1; i < res.size(); i += 2) {
            Collections.reverse(res.get(i));
        }
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
