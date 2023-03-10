package SameTree;

/**
 * Assume n is min(the number of nodes in tree p, that in tree q).
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Runtime: 4ms
 * Rank: 82.18%
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
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

}
