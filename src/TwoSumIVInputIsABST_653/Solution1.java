package TwoSumIVInputIsABST_653;

import java.util.HashSet;

/**
 * $$ Assume the number of the nodes in root is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */

public class Solution1 {
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k, new HashSet<>());
    }

    private boolean helper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(root.val)) {
            return true;
        }

        set.add(k - root.val);
        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
