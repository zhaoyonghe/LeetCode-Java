package BinaryTreeTilt;

/**
 * Assume the number of nodes in tree root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int res = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = helper(root.left);
        int ri = helper(root.right);

        res += Math.abs(le - ri);
        return root.val + le + ri;
    }
}
