package HouseRobberIII;

import java.util.HashMap;

/**
 * Assume n is the number of nodes in root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 6ms
 * Rank: 60.47%
 */
public class Solution1 {
    HashMap<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        return maxRob(root);
    }

    public int maxRob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        // rob this node
        // in this case we cannot rob the children of this node
        // rob children's children
        int rob = root.val;
        if (root.left == null && root.right == null) {

        } else if (root.left == null) {
            rob = rob + maxRob(root.right.left) + maxRob(root.right.right);
        } else if (root.right == null) {
            rob = rob + maxRob(root.left.left) + maxRob(root.left.right);
        } else {
            rob = rob + maxRob(root.left.left) + maxRob(root.left.right) + maxRob(root.right.left)
                    + maxRob(root.right.right);
        }
        // do not rob this node
        int norob = maxRob(root.left) + maxRob(root.right);
        int max = Math.max(rob, norob);
        map.put(root, max);
        return max;
    }
}
