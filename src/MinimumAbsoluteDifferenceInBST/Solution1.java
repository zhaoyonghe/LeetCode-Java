package MinimumAbsoluteDifferenceInBST;

/**
 * Assume the number of the nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 79.85%
 */

public class Solution1 {
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prevNode = null;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);

        if (prevNode == null) {
            prevNode = node;
        } else {
            minDiff = Math.min(minDiff, node.val - prevNode.val);
            prevNode = node;
        }

        inOrder(node.right);
    }
}
