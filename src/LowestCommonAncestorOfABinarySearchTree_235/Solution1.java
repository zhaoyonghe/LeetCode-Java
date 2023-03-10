package LowestCommonAncestorOfABinarySearchTree_235;

/**
 * Assume the height of root is h.
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 * Runtime: 6ms
 * Rank: 63.84%
 */

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            return helper(root, p.val, q.val);
        }
        return helper(root, q.val, p.val);
    }

    private TreeNode helper(TreeNode node, int p, int q) {
        if (node == null) {
            return null;
        }
        if (node.val < p) {
            return helper(node.right, p, q);
        }
        if (q < node.val) {
            return helper(node.left, p, q);
        }
        return node;
    }
}