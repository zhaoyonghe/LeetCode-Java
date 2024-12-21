package S.SameTree_100;

/**
 * $$ Assume n is the number of nodes in tree p and q; h is the max height of tree p and q.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both p and q are null.
        if (p == null && q == null) {
            return true;
        }
        // One and only one in p and q is null.
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
