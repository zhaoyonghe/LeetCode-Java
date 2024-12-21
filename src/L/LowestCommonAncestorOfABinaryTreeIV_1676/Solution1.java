package L.LowestCommonAncestorOfABinaryTreeIV_1676;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Assume the number of nodes in root is n.
 * Assume the height of root is h.
 * Time Complexity: O(n)
 * Auxiliary Space Complexity: O(h)
 * Runtime: 4ms
 * Rank: 76.02%
 */

public class Solution1 {
    // Important constraints:
    // 1. All nodes exist in the tree.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        return helper(root, Arrays.stream(nodes).collect(Collectors.toSet()));
    }

    private TreeNode helper(TreeNode root, Set<TreeNode> nodes) {
        if (root == null || nodes.contains(root)) {
            return root;
        }
        TreeNode le = helper(root.left, nodes);
        TreeNode ri = helper(root.right, nodes);
        if (le != null && ri != null) {
            return root;
        }
        return le == null ? ri : le;
    }
}
