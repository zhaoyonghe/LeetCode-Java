package BinaryTreeVerticalOrderTraversal_314;

import java.util.*;

/**
 * Assume n is the number of nodes in the tree root.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 2ms
 * Rank: 91.58%
 */

public class Solution1 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Deque<Info> q = new ArrayDeque<>();
        q.offer(new Info(root, 0));
        int mi = 0;
        while (!q.isEmpty()) {
            Info info = q.poll();
            TreeNode node = info.node;
            int col = info.col;
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer>());
                mi = Math.min(mi, col);
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                q.offer(new Info(node.left, col - 1));
            }
            if (node.right != null) {
                q.offer(new Info(node.right, col + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < map.keySet().size(); i++) {
            res.add(map.get(mi++));
        }
        return res;
    }

    private class Info {
        TreeNode node;
        int col;

        Info(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
