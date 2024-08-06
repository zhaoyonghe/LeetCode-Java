package KthSmallestElementInABST_230;

/**
 * $$ Assume the number of nodes in root is n, root height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        preOrder(root, k);
        return res;
    }

    private void preOrder(TreeNode node, int k) {
        if (node == null) {
            return;
        }
        preOrder(node.left, k);
        count++;
        if (count == k) {
            res = node.val;
        }
        preOrder(node.right, k);
    }
}
