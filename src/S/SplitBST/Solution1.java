package S.SplitBST;

/**
 * Assume the number of the nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 0ms
 * Rank: 100.00%
 */

public class Solution1 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }

        if (V < root.val) {
            TreeNode[] lr = splitBST(root.left, V);
            root.left = lr[1];
            return new TreeNode[]{lr[0], root};
        } else if (V > root.val) {
            TreeNode[] lr = splitBST(root.right, V);
            root.right = lr[0];
            return new TreeNode[]{root, lr[1]};
        } else {
            TreeNode tmp = root.right;
            root.right = null;
            return new TreeNode[]{root, tmp};
        }
    }
}
