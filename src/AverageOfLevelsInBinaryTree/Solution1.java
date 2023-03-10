package AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the number of the nodes in root is n.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 11ms
 * Rank: 5.39%
 */

public class Solution1 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<List<Double>> collector = new ArrayList<>();

        levelOrder(root, 0, collector);
        for (List<Double> level : collector) {
            res.add(level.stream().mapToDouble(Double::doubleValue).sum() / (level.size()));
        }

        return res;
    }

    public void levelOrder(TreeNode root, int level, List<List<Double>> list) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(level).add((double) root.val);

        levelOrder(root.left, level + 1, list);
        levelOrder(root.right, level + 1, list);

        return;
    }
}
