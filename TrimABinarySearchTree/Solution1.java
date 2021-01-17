package TrimABinarySearchTree;

/**
 * Assume the number of nodes in tree root is n.
 * Time Complexity: O(n)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
