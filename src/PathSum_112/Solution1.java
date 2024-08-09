package PathSum_112;

/**
 * $$ Assume the number of nodes in root is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int cur) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return cur + root.val == sum;
        }
        return hasPathSum(root.left, sum, cur + root.val) || hasPathSum(root.right, sum, cur + root.val);
    }
}
