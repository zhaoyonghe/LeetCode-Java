package V.VerticalOrderTraversalOfABinaryTree_987;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Assume the number of the nodes in root is n.
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 * Runtime: 10ms
 * Rank: 5.13%
 */

public class Solution1 {
    // Important constraints:
    // 1. The number of nodes in the tree is in the range [1, 1000] (null-check is unnecessary)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> m = new HashMap<>();
        helper(root, 0, 0, m);
        int max = m.keySet().stream().max(Integer::compare).get();
        int min = m.keySet().stream().min(Integer::compare).get();
        List<List<Integer>> res = new ArrayList<>(max - min);
        for (int i = 0; i <= max - min; i++) {
            res.add(null);
        }
        for (Map.Entry<Integer, List<int[]>> en : m.entrySet()) {
            int col = en.getKey();
            List<int[]> li = en.getValue();
            res.set(col - min, li.stream().sorted((a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }).map(a -> a[1]).collect(Collectors.toList()));
        }
        return res;
    }

    private void helper(TreeNode node, int row, int col, Map<Integer, List<int[]>> m) {
        if (node == null) {
            return;
        }
        if (!m.containsKey(col)) {
            m.put(col, new ArrayList<>());
        }
        m.get(col).add(new int[]{row, node.val});
        helper(node.left, row + 1, col - 1, m);
        helper(node.right, row + 1, col + 1, m);
    }
}