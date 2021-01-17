package FlattenBinaryTreeToLinkedList;

/**
 * Assume n is the number of nodes in tree root.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */
public class Solution1 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode le = root.left;
        TreeNode ri = root.right;

        root.left = null;
        root.right = null;

        flatten(le);
        flatten(ri);

        // connect le to root.right
        root.right = le;

        // connect ri to main stream
        TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        temp.right = ri;

        return;
    }
}
