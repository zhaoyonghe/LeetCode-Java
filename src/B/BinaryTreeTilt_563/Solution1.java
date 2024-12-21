package B.BinaryTreeTilt_563;

/**
 * $$ Assume the number of nodes in tree root is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    private int tiltSum = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return this.tiltSum;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int le = helper(node.left);
        int ri = helper(node.right);
        this.tiltSum += Math.abs(le - ri);
        return le + ri + node.val;
    }
}
