package RecoverBinarySearchTree;

/**
 * Assume the number of the nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 2ms
 * Rank: 99.99%
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
