package BalancedBinaryTree;

/**
 * Assume the depth of the tree is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.15%
 */
public class Solution1 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) >= 0;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (leftHeight < 0 || rightHeight < 0) {
            return -1;
        }

        // calculate the height of current tree from the height of left subtree and right subtree
        // if the current tree is imbalance, return a special value
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}
