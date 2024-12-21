package D.DiameterOfBinaryTree_543;

/**
 * $$ Assume the number of nodes in root is n; the height of root is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    private int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int le = depth(node.left);
        int ri = depth(node.right);

        res = Math.max(res, le + ri);
        return Math.max(le, ri) + 1;
    }
}
