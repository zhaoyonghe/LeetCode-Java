package LongestUnivaluePath;

/**
 * Assume the number of the nodes in root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 5ms
 * Rank: 70.01%
 */
public class Solution1 {
    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        longestPath(root);
        return Math.max(0, res - 1);
    }

    public int longestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int le = longestPath(node.left);
        int ri = longestPath(node.right);

        int conn = 1;
        int noconn = 1;
        if (node.left != null && node.val == node.left.val) {
            conn += le;
            noconn += le;
        }
        if (node.right != null && node.val == node.right.val) {
            conn += ri;
            noconn = Math.max(noconn, 1 + ri);
        }

        res = Math.max(res, Math.max(conn, noconn));
        return noconn;
    }
}
