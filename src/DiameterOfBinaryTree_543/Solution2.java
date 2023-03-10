package DiameterOfBinaryTree_543;

/**
 * Assume the number of the nodes in root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution2 {
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return res;
    }

    private int res = 0;

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
