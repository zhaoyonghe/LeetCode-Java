package L.LowestCommonAncestorOfABinarySearchTree_235;

/**
 * $$ Assume the height of root is h.
 * $$ Time Complexity: O(h)
 * $$ Space Complexity: O(h)
 */

public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        return helper(root, p, q);
    }

    private TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        if (root.val < p.val) {
            return helper(root.right, p, q);
        }
        if (root.val > q.val) {
            return helper(root.left, p, q);
        }
        return root;
    }
}