package AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Assume the number of nodes in tree root is n.
 * Assume the height of the tree is h.
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 * Runtime: 1ms
 * Rank: 99.95%
 */

public class Solution2 {
    public List<Double> averageOfLevels(TreeNode root) {
        int h = height(root);
        List<Double> res = new ArrayList<>();

        int[] count = new int[h];
        double[] sum = new double[h];

        levelOrder(root, 0, sum, count);
        for (int i = 0; i < h; i++) {
            res.add(sum[i] / count[i]);
        }

        return res;
    }

    public void levelOrder(TreeNode root, int i, double[] sum, int[] count) {
        if (root == null) {
            return;
        }

        sum[i] += (double) root.val;
        count[i]++;

        levelOrder(root.left, i + 1, sum, count);
        levelOrder(root.right, i + 1, sum, count);
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }
}
