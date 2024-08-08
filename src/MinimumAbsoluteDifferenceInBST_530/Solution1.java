package MinimumAbsoluteDifferenceInBST_530;

/**
 * $$ Assume the number of the nodes in root is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    private Integer prev = null;
    private int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return this.min;
    }

    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        if (prev != null) {
            this.min = Math.min(this.min, Math.abs(this.prev-node.val));
        }
        this.prev = node.val;
        traverse(node.right);
    }
}
