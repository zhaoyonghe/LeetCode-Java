package SubtreeOfAnotherTree_572;

import java.util.*;
/**
 * $$ Assume n is the number of nodes in root; m is the number of nodes in subRoot; h is the height of subRoot.
 * $$ Time Complexity: O(n * m)
 * $$ Space Complexity: O(h)
 */
public class Solution1 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return root != null && (same(root, subRoot)|| isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    private boolean same(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val && same(a.left,b.left)&&same(a.right,b.right);
    }
}