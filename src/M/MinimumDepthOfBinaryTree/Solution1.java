package M.MinimumDepthOfBinaryTree;

/**
 * Assume the length of the linked list is n.
 * Time Complexity: O(n)
 * Space Complexity: O(logn)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getMinDepth(root);
    }

    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // if it is a leaf
        if (root.left == null && root.right == null) {
            return 1;
        }

        return 1 + Math.min(getMinDepth(root.left), getMinDepth(root.right));
    }
}
