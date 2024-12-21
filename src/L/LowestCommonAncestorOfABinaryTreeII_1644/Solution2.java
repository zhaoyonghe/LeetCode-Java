package L.LowestCommonAncestorOfABinaryTreeII_1644;

/**
 * Assume the number of nodes in root is n.
 * Assume the height of root is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 16ms
 * Rank: 38.88%
 */

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q)[2];
    }

    private TreeNode[] helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new TreeNode[3];
        }
        TreeNode[] le = helper(root.left, p, q);
        if (le[2] != null) {
            return le;
        }
        TreeNode[] ri = helper(root.right, p, q);
        if (ri[2] != null) {
            return ri;
        }
        le[0] = choose(le[0], ri[0], root == p ? p : null);
        le[1] = choose(le[1], ri[1], root == q ? q : null);
        if (le[0] != null && le[1] != null) {
            le[2] = root;
        }
        return le;
    }

    private TreeNode choose(TreeNode a, TreeNode b, TreeNode c) {
        if (a != null) {
            return a;
        }
        if (b != null) {
            return b;
        }
        return c;
    }
}