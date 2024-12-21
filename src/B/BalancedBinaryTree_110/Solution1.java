package B.BalancedBinaryTree_110;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = height(root.left);
        int hr = height(root.right);
        return hl == -1 || hr == -1 || Math.abs(hl - hr) > 1 ? -1 : Math.max(hl, hr) + 1;
    }
}
