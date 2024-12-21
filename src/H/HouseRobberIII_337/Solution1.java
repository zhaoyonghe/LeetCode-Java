package H.HouseRobberIII_337;

/**
 * $$ Assume n is the number of nodes in root.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */
public class Solution1 {
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    // return: max earn from robbing subtree `node` [if rob the root `node`, if not rob the root `node`]
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] le = helper(node.left);
        int[] ri = helper(node.right);
        return new int[]{node.val + le[1] + ri[1], Math.max(le[0], le[1]) + Math.max(ri[0], ri[1])};
    }
}
