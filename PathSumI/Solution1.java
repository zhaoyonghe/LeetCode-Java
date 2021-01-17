package PathSumI;

/**
 * Assume the number of nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.49%
 */
public class Solution1 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum(TreeNode root, int sum, int cur) {
        if (root.left == null && root.right == null) {
            if (cur + root.val == sum) {
                return true;
            } else {
                return false;
            }
        }

        if (root.left != null) {
            if (hasPathSum(root.left, sum, cur + root.val)) {
                return true;
            }
        }

        if (root.right != null) {
            if (hasPathSum(root.right, sum, cur + root.val)) {
                return true;
            }
        }

        return false;
    }

}
