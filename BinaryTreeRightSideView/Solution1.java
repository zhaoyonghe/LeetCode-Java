package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the number of nodes in tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        levelOrder(root, 0, list);
        return list;
    }

    // level order traversal, but just return the rightmost node
    public void levelOrder(TreeNode node, int level, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (list.size() == level) {
            list.add(null);
        }

        levelOrder(node.left, level + 1, list);
        list.set(level, node.val);
        levelOrder(node.right, level + 1, list);
    }
}
