package F.FlattenBinaryTreeToLinkedList;

/**
 * Assume n is the number of nodes in tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution2 {
    TreeNode last = null;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            root.right = last;
            last = root;
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.left = null;
        root.right = null;
        root.right = last;
        last = root;
    }
}
