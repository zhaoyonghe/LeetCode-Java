package LowestCommonAncestorOfABinaryTree;

/**
 * Assume the number of nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 7ms
 * Rank: 99.87%
 */

public class Solution4 {
    private TreeNode ancestor;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ancestor;
    }

    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        boolean le = helper(root.left, p, q);
        boolean ri = helper(root.right, p, q);

        if ((le && ri) || ((root == p || root == q) && (le || ri))) {
            ancestor = root;
        }

        return le || ri || root == p || root == q;
    }
}
