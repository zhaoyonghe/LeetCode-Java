package InvertBinaryTree_226;

/**
 * $$ Assume the nodes count of root is n, height is h.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */

public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        return root == null ? null : new TreeNode(root.val, invertTree(root.right), invertTree(root.left));
    }
}