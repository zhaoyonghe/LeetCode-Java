package BinaryTreeInorderTraversal_94;

import java.util.*;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution2 {
    // Straight forward, but destroys the tree structure.
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                res.add(node.val);
                continue;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            stack.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            node.right = null;
        }

        return res;
    }
}
