package RecoverBinarySearchTree_99;

/**
 * Assume the number of the nodes in root is n; root height is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 100.00%
 */

public class Solution1 {
    private TreeNode first, second, prev;

    public void recoverTree(TreeNode root) {
        inOrder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (prev != null) {
            if (prev.val > node.val) {
                if (first == null) {
                    first = prev;
                }
                second = node;
            }
        }
        prev = node;
        inOrder(node.right);
    }
}
