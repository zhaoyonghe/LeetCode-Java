package BinaryTreeRightSideView_199;

import java.util.ArrayList;
import java.util.List;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */

public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        levelOrder(root, 0, res);
        return res;
    }

    private void levelOrder(TreeNode node, int level, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(node.val);
        }
        res.set(level, node.val);
        levelOrder(node.left, level + 1, res);
        levelOrder(node.right, level + 1, res);
    }
}
