package HouseRobberIII;

import java.util.HashMap;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 60.47%
 */
public class Solution2 {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        return maxRob(root);
    }

    public int maxRob(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        int rob = node.val;
        if (node.left != null) {
            rob += (maxRob(node.left.left) + maxRob(node.left.right));
        }
        if (node.right != null) {
            rob += (maxRob(node.right.left) + maxRob(node.right.right));
        }
        int norob = maxRob(node.left) + maxRob(node.right);
        int max = Math.max(rob, norob);
        map.put(node, max);
        return max;
    }
}
