package A.AllNodesDistanceKInBinaryTree_863;

/**
 * $$ Assume the nodes count of root is n.
 * $$ Time Complexity: O(n)
 * $$ Space Complexity: O(n)
 */


import java.util.*;

public class Solution2 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // convert the tree to an undirected graph
        Map<Integer, Set<Integer>> g = new HashMap<>();
        build(root, g);
        // BFS from target, go for k steps, collect all nodes
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(target.val);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            if (k == 0) {
                break;
            }
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                if (!g.containsKey(cur)) {
                    continue;
                }
                for (int next : g.get(cur)) {
                    if (visited.contains(next)) {
                        continue;
                    }
                    q.offer(next);
                    visited.add(next);
                }
            }
            k--;
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }

    private void build(TreeNode node, Map<Integer, Set<Integer>> g) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            putEdge(g, node.val, node.left.val);
            build(node.left, g);
        }
        if (node.right != null) {
            putEdge(g, node.val, node.right.val);
            build(node.right, g);
        }
    }

    private void putEdge(Map<Integer, Set<Integer>> g, int a, int b) {
        g.putIfAbsent(a, new HashSet<>());
        g.putIfAbsent(b, new HashSet<>());
        g.get(a).add(b);
        g.get(b).add(a);
    }

}