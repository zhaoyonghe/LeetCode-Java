package LowestCommonAncestorOfABinaryTree_236;

/**
 * $$ Assume the number of nodes in root is n, root height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */

public class Solution1 {
    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }

    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean rootIsPOrQ = root == p || root == q;
        boolean leftContainsPOrQ = helper(root.left, p, q);
        boolean rightContainsPOrQ = helper(root.right, p, q);
        if ((rootIsPOrQ && leftContainsPOrQ) || (rootIsPOrQ && rightContainsPOrQ) || (leftContainsPOrQ && rightContainsPOrQ)) {
            res = root;
        }
        return rootIsPOrQ || leftContainsPOrQ || rightContainsPOrQ;
    }
}
