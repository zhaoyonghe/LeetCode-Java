package CountGoodNodesInBinaryTree_1148;

/**
 * Assume the nodes count of root is n, height is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 2ms
 * Rank: 96.46%
 */
public class Solution1 {
    // Important constraints:
    // Each node's value is between [-10^4, 10^4]
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }
    private int helper(TreeNode root, int preMax) {
        if (root == null) {
            return 0;
        }
        int cur = 1, nextMax = root.val;
        if (root.val < preMax) {
            cur = 0;
            nextMax = preMax;
        }
        return cur + helper(root.left, nextMax) + helper(root.right, nextMax);
    }
}