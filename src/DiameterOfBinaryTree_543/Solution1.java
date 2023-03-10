package DiameterOfBinaryTree_543;

/**
 * Assume the number of the nodes in root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 50.3250.32%
 */
public class Solution1 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = helper(root);
        return Math.max(res[0], res[1]) - 1;
    }

    private int[] helper(TreeNode node) {
        // node != null
        if (node.left == null && node.right == null) {
            return new int[]{1,1};
        }
        int[] le = new int[]{0,0};
        int[] ri = new int[]{0,0};
        if (node.left != null) {
            le = helper(node.left);
        }
        if (node.right != null) {
            ri = helper(node.right);
        }
        return new int[]{Math.max(le[0],ri[0])+1,Math.max(Math.max(le[1],ri[1]),le[0]+ri[0]+1)};
    }
}
