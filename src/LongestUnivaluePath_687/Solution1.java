package LongestUnivaluePath_687;

/**
 * $$ Assume the number of the nodes in root is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    private int longest = 1;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return this.longest - 1;
    }

    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{1001, 1};
        }

        int[] le = helper(node.left);
        int[] ri = helper(node.right);

        int[] ret = new int[]{node.val, 1};
        if (node.val == le[0]) {
            ret[1] = Math.max(ret[1], le[1] + 1);
        }
        if (node.val == ri[0]) {
            ret[1] = Math.max(ret[1], ri[1] + 1);
        }
        this.longest = Math.max(this.longest, ret[1]);
        if (node.val == le[0] && node.val == ri[0]) {
            this.longest = Math.max(this.longest, le[1] + ri[1] + 1);
        }
        return ret;
    }
}
