package LowestCommonAncestorOfABinaryTree_236;

/**
 * Assume the number of nodes in root is n.
 * Assume the height of root is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 5ms
 * Rank: 98.45%
 */

public class Solution1 {
    // Important constraints:
    // 1. p, q exist in the tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode le = lowestCommonAncestor(root.left, p, q);
        TreeNode ri = lowestCommonAncestor(root.right, p, q);
        if (le != null && ri != null) {
            return root;
        }
        return le != null ? le : ri;
    }
}
