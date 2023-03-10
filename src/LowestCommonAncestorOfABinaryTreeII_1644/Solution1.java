package LowestCommonAncestorOfABinaryTreeII_1644;
/**
 * Assume the number of nodes in root is n.
 * Assume the height of root is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 8ms
 * Rank: 86.00%
 */

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return count(root, p, q) == 2 ? helper(root, p, q) : null;
    }

    private int count(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return 0;
        }
        return count(node.left, p, q) + count(node.right, p, q) + ((node == p || node == q) ? 1 : 0);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode le = helper(root.left, p, q);
        TreeNode ri = helper(root.right, p, q);
        if (le != null && ri != null) {
            return root;
        }
        return le != null ? le : ri;
    }
}