package ValidateBinarySearchTree_98;

/**
 * Assume n is the number of nodes in tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long lo, long hi) {
        if (node == null) {
            return  true;
        }
        long val = (long)node.val;
        if (val <= lo || val >= hi) {
            return false;
        }
        if (!helper(node.left, lo, val)) {
            return false;
        }
        return helper(node.right, val, hi);
    }

}
