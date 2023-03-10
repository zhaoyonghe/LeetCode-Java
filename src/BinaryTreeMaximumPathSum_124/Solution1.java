package BinaryTreeMaximumPathSum_124;

/**
 * Assume the number of the nodes in root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        res = root.val;
        f(root);
        return res;
    }

    private int res = 0;

    private int f(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int le = f(root.left);
        int ri = f(root.right);
        int ret = max(le,ri,0)+root.val;
        res = max(res, ret, le+ri+root.val);
        return ret;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
