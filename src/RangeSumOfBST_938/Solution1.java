package RangeSumOfBST_938;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    // Important constraints:
    // 1. All Node.val are unique.
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (low <= root.val && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, root.val) + rangeSumBST(root.right, root.val, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        // high < root.val
        return rangeSumBST(root.left, low, high);
    }
}