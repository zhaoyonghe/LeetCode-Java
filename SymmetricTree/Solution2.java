package SymmetricTree;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 13ms
 * Rank: 70.10%
 */
public class Solution2 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2) {
        // Both t1 and t2 are null.
        if (t1 == null && t2 == null) {
            return true;
        }
        // One and only one in t1 and t2 is null.
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

}
