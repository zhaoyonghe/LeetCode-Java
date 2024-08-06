package BinaryTreeMaximumPathSum_124;

/**
 * $$ Assume the number of nodes in root is n; the height of root is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */

public class Solution1 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int le = helper(node.left);
        int ri = helper(node.right);
        // Max sum of paths that include node and go straight down
        int ret = max3(le, ri, 0) + node.val;
        // Max sum of paths that pivot at node
        res = max3(res, ret, le + ri + node.val);
        return ret;
    }

    private int max3(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }
}
