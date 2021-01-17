package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalWithoutReturn(root, list);
        return list;
    }

    public void preorderTraversalWithoutReturn(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalWithoutReturn(root.left, list);
        preorderTraversalWithoutReturn(root.right, list);
    }
}
