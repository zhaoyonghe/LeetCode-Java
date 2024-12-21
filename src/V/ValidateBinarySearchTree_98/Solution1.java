package V.ValidateBinarySearchTree_98;

/**
 * $$ Assume the number of nodes in root is n, root height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean helper(TreeNode root, long lower, long upper) {
        return root == null || (lower < root.val && root.val < upper && helper(root.left, lower, root.val) && helper(root.right, root.val, upper));
    }

}
