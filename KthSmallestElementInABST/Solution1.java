package KthSmallestElementInABST;

/**
 * Time Complexity: O(k)
 * Space Complexity: O(1)
 * Runtime: 1ms
 * Rank: 99.85%
 */
public class Solution1 {

    private int i = 0;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        levelOrder(root, k);
        return result;
    }

    public void levelOrder(TreeNode node, int k) {
        // travel the left subtree
        if (node.left != null) {
            levelOrder(node.left, k);
        }

        // if meet the situation, stop every traversal
        if (i == k) {
            return;
        }

        // node.left == null && i != k
        i += 1;
        if (i == k) {
            result = node.val;
            return;
        }

        // travel the right subtree
        if (node.right != null) {
            levelOrder(node.right, k);
        }

        // if meet the situation, stop every traversal
        if (i == k) {
            return;
        }
    }
}
